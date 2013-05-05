package daos;

import models.TwitterRequestToken;

import org.bson.types.ObjectId;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

import twitter4j.auth.RequestToken;

import com.mongodb.DB;

public class MongoTwitterRequestTokenDAO implements TwitterRequestTokenDAO
{
	private JacksonDBCollection<TwitterRequestToken, String> coll;
	
	private TwitterRequestToken toDBToken(String userId, RequestToken token)
	{
		if ( token == null || !ObjectId.isValid(userId) )
		{
			return null;
		}
		
		return new TwitterRequestToken(userId, token.getToken(), token.getTokenSecret(), token.getAuthorizationURL(), token.getAuthenticationURL());
	}
	
	private RequestToken toDTO(TwitterRequestToken token)
	{
		if ( token == null )
		{
			return null;
		}
		return new RequestToken(token.getToken(), token.getTokenSecret());
	}
	
	public MongoTwitterRequestTokenDAO(DB db)
	{
		coll = JacksonDBCollection.wrap(db.getCollection("twitter.request_tokens"), TwitterRequestToken.class, String.class);
	}
	
	
	
	@Override
	public RequestToken findByUser(String userId)
	{
		if ( !ObjectId.isValid(userId) )
		{
			return null;
		}
		TwitterRequestToken find = coll.findOneById(userId);
	
		return toDTO(find);
	}

	@Override
	public boolean save(String userId, RequestToken token)
	{
		TwitterRequestToken dbToken = toDBToken(userId, token);
		if ( dbToken == null )
		{
			return false;
		}
		
		WriteResult<TwitterRequestToken, String> insert = coll.insert(dbToken);
		return insert.getSavedId() != null;
	}

	@Override
	public boolean update(String userId, RequestToken token)
	{
		TwitterRequestToken dbToken = toDBToken(userId, token);
		if ( dbToken == null )
		{
			return false;
		}
		WriteResult<TwitterRequestToken, String> wr = coll.updateById(userId, dbToken);
		return wr.getN() == 1;
	}

	@Override
	public boolean remove(String userId)
	{
		if ( !ObjectId.isValid(userId) )
		{
			return false;
		}
		WriteResult<TwitterRequestToken, String> wr = coll.removeById(userId);
		return wr.getN() == 1;
	}
	
}
