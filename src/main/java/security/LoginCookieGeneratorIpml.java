package security;

import java.net.URI;
import java.util.Date;

import javax.ws.rs.core.NewCookie;

import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.DB;
import com.yammer.dropwizard.util.Duration;

public class LoginCookieGeneratorIpml
{
	private final static Logger LOG = LoggerFactory.getLogger(LoginCookieGeneratorIpml.class);
	private URI serverURI;
	private JacksonDBCollection<LoginToken, String> coll;
	
	public LoginCookieGeneratorIpml(DB db, URI serverURI)
	{
		super();
		this.serverURI = serverURI;
		this.coll = JacksonDBCollection.wrap(db.getCollection("login_tokens"), LoginToken.class, String.class);
	}

	public String generateResponse(User user, boolean remember, String ip)
	{
		final long curTime = System.currentTimeMillis();
		final Date issuedAt = new Date(curTime);
		
		final String issuedFor = user.getId();
		final Duration expireIn; 
		
		
		
		if ( remember )
		{
			expireIn = Duration.days(6 * 30);
		}
		else
		{
			expireIn = Duration.minutes(10);
		}

		final Date expireAt = new Date(curTime + expireIn.toMilliseconds());

		final Date revoked = null;
		LoginToken loginToken = new LoginToken(null, issuedFor, null, issuedAt, expireAt, remember, revoked);
		WriteResult<LoginToken, String> insert = coll.insert(loginToken);
		String tokenId = insert.getSavedId();
		
		final String serverName = serverURI.getHost();
		
		String domain = serverName.equals("localhost") ? "" : serverName;
		
		// Save the token
		
		final boolean isHttps = "https".equals(serverURI.getScheme()) ? true : false;		// if server is https cookie is only available for https
		
		if ( remember )
		{
			final int maxAge = (int) Duration.days(180).toSeconds();
			NewCookie cookie = new NewCookie("VA_SHIRLEY", tokenId, "/", domain, null, maxAge, isHttps);
			LOG.debug("cookie.toString() : {}", cookie.toString());
			return cookie.toString() + ";HttpOnly";
		}
		else
		{
			NewCookie cookie = new NewCookie("VA_SHIRLEY", tokenId, "/", domain, "no Comment", -1, isHttps);
			LOG.debug("cookie.toString() : {}", cookie.toString());
			return cookie.toString() + ";HttpOnly";
		}
	}
	
	public String destroyCookie(String getId)
	{
		final String serverName = serverURI.getHost();
		
		String domain = serverName.equals("localhost") ? "" : serverName;
		
		// remove the token
		coll.removeById(getId);
		
		final boolean isHttps = "https".equals(serverURI.getScheme()) ? true : false;		// if server is https cookie is only available for https
		
		NewCookie cookie = new NewCookie("VA_SHIRLEY", null, "/", domain, null, 0, isHttps);
		LOG.debug("cookie.toString() : {}", cookie.toString());
		return cookie.toString() + ";HttpOnly";
	}

}
