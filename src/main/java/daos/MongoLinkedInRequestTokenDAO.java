package daos;

import javax.ws.rs.core.UriBuilder;

import org.bson.types.ObjectId;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

import com.google.code.linkedinapi.client.oauth.LinkedInRequestToken;
import com.mongodb.DB;

public class MongoLinkedInRequestTokenDAO implements LinkedInRequestTokenDAO
{
	private JacksonDBCollection<models.LinkedInRequestToken, String> coll;

	private models.LinkedInRequestToken toDBToken(LinkedInRequestToken token)
	{
		if (token == null)
		{
			return null;
		}
		models.LinkedInRequestToken linkedInRequestToken = new models.LinkedInRequestToken();
		linkedInRequestToken.setToken(token.getToken());
		linkedInRequestToken.setTokenSecret(token.getTokenSecret());
		linkedInRequestToken.setAuthorizationUrl(UriBuilder.fromUri(token.getAuthorizationUrl()).build());
		linkedInRequestToken.setExpirationTime(token.getExpirationTime());
		return linkedInRequestToken;
	}
	
	private LinkedInRequestToken toDTO(models.LinkedInRequestToken token)
	{
		if (token == null)
		{
			return null;
		}
		LinkedInRequestToken linkedInRequestToken = new LinkedInRequestToken(token.getToken(), token.getTokenSecret());
		linkedInRequestToken.setExpirationTime(token.getExpirationTime());
		return linkedInRequestToken;
	}
	
	public MongoLinkedInRequestTokenDAO(
			DB db)
	{
		super();
		coll = JacksonDBCollection.wrap(
				db.getCollection("linkedin.request_tokens"),
				models.LinkedInRequestToken.class, String.class);
	}

	@Override
	public LinkedInRequestToken getRequestTokenByDeveloper(String developerId)
	{
		if ( !ObjectId.isValid(developerId) )
		{
			return null;
		}
		models.LinkedInRequestToken find = coll.findOneById(developerId);
		
		return toDTO(find);
	}

	@Override
	public boolean save(String userId, LinkedInRequestToken token)
	{
		if ( ObjectId.isValid(userId) )
		{
			return false;
		}
		models.LinkedInRequestToken dbToken = toDBToken(token);
		dbToken.setId(userId);
		WriteResult<models.LinkedInRequestToken, String> insert = coll.insert(dbToken);
		return insert.getSavedId() != null;
	}

	@Override
	public boolean remove(String userId)
	{
		if ( !ObjectId.isValid(userId) )
		{
			return false;
		}
		WriteResult<models.LinkedInRequestToken, String> remove = coll.removeById(userId);
		return remove.getN() == 1;
	}
	
	
	
	
}
