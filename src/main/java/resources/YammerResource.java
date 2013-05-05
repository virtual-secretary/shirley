package resources;

import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import models.YammerAccessToken;

import org.mongojack.JacksonDBCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import security.UAuth;
import security.User;
import clients.YammerClient;

import com.mongodb.DB;

import daos.UserDAO;

@Path("/oauth/yammer")
public class YammerResource
{
	public static String reqToken;
	
	private final static Logger LOG = LoggerFactory.getLogger(YammerResource.class);
	
	private static final String CLIENT_KEY = "IDy1kcPFW8toHARsOdMZQ";
	private static final String CLIENT_SECRET = "8oAqqwIbdU6VEKXF56J3qnhLYbnlHRmIKqVYw7NiE";
	
	private URI serverURI;
	private UserDAO userDAO;
	private YammerClient yClient;
	
	private JacksonDBCollection<YammerAccessToken, String> coll;
	
	private URI getAbsoluteResourceURI()
	{
		return UriBuilder.fromUri(
							serverURI.getScheme() + "://" + serverURI.getHost()
							).path("api").path( 
							UriBuilder.fromResource(YammerResource.class).build().toString()
						  )
						 .build();
	}
	
	public YammerResource(URI serverURI, YammerClient yClient, UserDAO userDAO, DB db)
	{
		super();
		this.serverURI = serverURI;
		this.yClient = yClient;
		coll = JacksonDBCollection.wrap(db.getCollection("yammer.access_tokens"), YammerAccessToken.class, String.class);
		this.userDAO = userDAO;
	}


	@GET
	@Path("auth")
	public Response auth(@UAuth User user, 
			@QueryParam("method") String method) throws Exception
	{
		URI redirectURL = UriBuilder.fromUri(getAbsoluteResourceURI())
									.path(method).build();
		
		URI authURL = UriBuilder.fromUri("https://www.yammer.com/dialog/oauth")
								.queryParam("client_id", CLIENT_KEY)
								.queryParam("redirect_uri", redirectURL.toString()).build();
		
		return Response.seeOther(authURL).build();
	}
	
	@GET
	@Path("connect")
	public Response connect(
			@UAuth User user,
			@QueryParam("code") String code) throws Exception
	{
		YammerAccessToken accessToken = yClient.getAccessToken(code);
		
		if ( accessToken != null )
		{
			accessToken.setId(user.getId());
			coll.insert(accessToken);
			
			user.getSetting().setYammer(true);
			userDAO.updateSetting(user);
			
			LOG.debug("\n\t Got accessToken {}", accessToken);
		}
		return Response.ok(accessToken).type(MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("profile")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getProfile(
			@UAuth User user,
			@QueryParam("q") String q) throws Exception
	{
		YammerAccessToken token = coll.findOneById(user.getId());
		
		if ( token == null || !user.getSetting().isYammer() )
		{
			// TODO : DO SOMETHING
		}
		
		return yClient.getUserProfile(token.getToken(), q);
	}
}
