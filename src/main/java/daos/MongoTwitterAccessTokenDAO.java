package daos;

import models.TwitterAccessToken;

import org.bson.types.ObjectId;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

import twitter4j.auth.AccessToken;

import com.mongodb.DB;

public class MongoTwitterAccessTokenDAO implements TwitterAccessTokenDAO
{
	private JacksonDBCollection<TwitterAccessToken, String> coll;

	private TwitterAccessToken toDBToken(String userId, AccessToken token)
	{
		if ( token == null || !ObjectId.isValid(userId) )
		{
			return null;
		}
		
		return new TwitterAccessToken(userId, token.getToken(), token.getTokenSecret());
	}
	
	private AccessToken toDTO(TwitterAccessToken token)
	{
		if ( token == null )
		{
			return null;
		}
		return new AccessToken(token.getToken(), token.getTokenSecret());
	}
	
	public MongoTwitterAccessTokenDAO(DB db)
	{
		this.coll = JacksonDBCollection.wrap(db.getCollection("twitter.access_token"), TwitterAccessToken.class, String.class);
	}
	
	@Override
	public AccessToken findByUser(String userId)
	{
		if ( !ObjectId.isValid(userId) )
		{
			return null;
		}
		TwitterAccessToken find = coll.findOneById(userId);
	
		return toDTO(find);
	}

	@Override
	public boolean save(String userId, AccessToken token)
	{
		TwitterAccessToken dbToken = toDBToken(userId, token);
		if ( dbToken == null )
		{
			return false;
		}
		
		WriteResult<TwitterAccessToken, String> insert = coll.insert(dbToken);
		return insert.getSavedId() != null;
	}

	@Override
	public boolean update(String userId, AccessToken token)
	{
		TwitterAccessToken dbToken = toDBToken(userId, token);
		if ( dbToken == null )
		{
			return false;
		}
		WriteResult<TwitterAccessToken, String> wr = coll.updateById(userId, dbToken);
		return wr.getN() == 1;
	}

	@Override
	public boolean remove(String userId)
	{
		if ( !ObjectId.isValid(userId) )
		{
			return false;
		}
		WriteResult<TwitterAccessToken, String> wr = coll.removeById(userId);
		return wr.getN() == 1;
	}

}
