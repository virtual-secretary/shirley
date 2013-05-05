package security;

import java.util.Date;

import org.bson.types.ObjectId;
import org.mongojack.DBCursor;
import org.mongojack.DBQuery;
import org.mongojack.DBUpdate;
import org.mongojack.JacksonDBCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.yammer.dropwizard.auth.AuthenticationException;
import com.yammer.dropwizard.auth.Authenticator;
import com.yammer.dropwizard.util.Duration;

public class UAuthAuthenticator implements Authenticator<String, User>
{
	private final Duration LONG_EXPIRE_TIME = Duration.days(6 * 30);
	private final Duration SHORT_EXPIRE_TIME = Duration.minutes(30);
	
	private final static Logger LOG = LoggerFactory.getLogger(UAuthAuthenticator.class);
	
	private JacksonDBCollection<LoginToken, String> tokenDAO;
	private JacksonDBCollection<User, String> userDAO;
	
	public UAuthAuthenticator(Mongo m, DB db)
	{
		super();
		tokenDAO = JacksonDBCollection.wrap(db.getCollection("login_tokens"), LoginToken.class, String.class);
		userDAO = JacksonDBCollection.wrap(db.getCollection("users"), User.class, String.class);
	}

	@Override
	public Optional<User> authenticate(String credentials)
			throws AuthenticationException
	{
		// TokenCollection
		
		DBCursor<LoginToken> tokenCur = tokenDAO.find(DBQuery.is("_id", new ObjectId(credentials)));
		
		if ( tokenCur.hasNext() )
		{
			final LoginToken aToken = tokenCur.next();
			final String userId = aToken.getIssuedFor();
			// Check user status
			DBCursor<User> user = userDAO.find(DBQuery.is("_id", userId));
			
			if ( user.hasNext() )
			{
				final User aUser = user.next();
				if ( aToken.isExpired() || aToken.isRevoked() )
				{
					// Token is expired or revoked
					LOG.debug("aToken is either expired or revoked");
					throw new AuthenticationException("Invalid token");
				}
				
				// Token is valid reset expire time according to its remember option
				if ( aToken.isRemember() )
				{
					aToken.setExpireAt(new Date(System.currentTimeMillis() + LONG_EXPIRE_TIME.toMilliseconds()) );
				}
				else
				{
					aToken.setExpireAt(new Date(System.currentTimeMillis() + SHORT_EXPIRE_TIME.toMilliseconds()) );
				}
				
				tokenDAO.update(
						DBQuery.is("_id", new ObjectId(aToken.getId())),
						DBUpdate.set("expireAt", aToken.getExpireAt()));
				
				// return the user
				return Optional.fromNullable(aUser);
			}
		}
		return Optional.absent();
	}

}
