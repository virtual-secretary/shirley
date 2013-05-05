package daos;

import models.LinkedInAccessTokenDAO;

import org.bson.types.ObjectId;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.mongodb.DB;

public class MongoLinkedInAccessTokenDAO implements LinkedInAccessTokenDAO
{
	private JacksonDBCollection<models.LinkedInAccessToken, String> coll;
	
	private LinkedInAccessToken toDTO(models.LinkedInAccessToken token)
	{
		if ( token == null )
		{
			return null;
		}
		LinkedInAccessToken linkedInAccessToken = new LinkedInAccessToken(token.getToken(), token.getTokenSecret());
		linkedInAccessToken.setExpirationTime(token.getExpirationTime());
		return linkedInAccessToken;
	}
	
	private models.LinkedInAccessToken toDBToken(LinkedInAccessToken token)
	{
		if ( token == null )
		{
			return null;
		}
		
		return new models.LinkedInAccessToken(null, token.getToken(), token.getTokenSecret(), token.getExpirationTime());
	}
	
	public MongoLinkedInAccessTokenDAO(DB db)
	{
		coll = JacksonDBCollection.wrap(
				db.getCollection("linkedin.access_tokens"),
				models.LinkedInAccessToken.class, String.class);
	}

	@Override
	public LinkedInAccessToken getRequestTokenByDeveloper(String userId)
	{
		if ( !ObjectId.isValid(userId) )
		{
			return null;
		}
		
		return toDTO(coll.findOneById(userId));
	}

	@Override
	public boolean save(String userId, LinkedInAccessToken token)
	{
		if ( !ObjectId.isValid(userId) )
		{
			return false;
		}
		models.LinkedInAccessToken dbToken = toDBToken(token);
		dbToken.setId(userId);
		WriteResult<models.LinkedInAccessToken, String> save = coll.save(dbToken);
		return save.getSavedId() != null;
	}

	@Override
	public boolean remove(String userId)
	{
		if ( !ObjectId.isValid(userId) )
		{
			return false;
		}
		WriteResult<models.LinkedInAccessToken, String> remove = coll.removeById(userId);
		return remove.getN() == 1;
	}

	@Override
	public boolean update(String userId, LinkedInAccessToken token)
	{
		if ( !ObjectId.isValid(userId) )
		{
			return false;
		}
		models.LinkedInAccessToken dbToken = toDBToken(token);
		dbToken.setId(userId);
		
		WriteResult<models.LinkedInAccessToken, String> save = coll.updateById(userId, dbToken);
		return save.getN() == 1;
	}
}
