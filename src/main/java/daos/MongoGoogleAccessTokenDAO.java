package daos;

import models.GoogleAccessToken;

import org.bson.types.ObjectId;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

import com.mongodb.DB;

public class MongoGoogleAccessTokenDAO implements GoogleAccessTokenDAO
{
	private JacksonDBCollection<GoogleAccessToken, String> coll;
	
	public MongoGoogleAccessTokenDAO(DB db)
	{
		coll = JacksonDBCollection.wrap(db.getCollection("google.access_tokens"), GoogleAccessToken.class, String.class);
	}

	@Override
	public GoogleAccessToken findByUser(String userId)
	{
		if ( !ObjectId.isValid(userId) )
		{
			return null;
		}
		GoogleAccessToken findOneById = coll.findOneById(userId);
		
		return findOneById;
	}

	@Override
	public boolean save(GoogleAccessToken token)
	{
		WriteResult<GoogleAccessToken, String> insert = coll.insert(token);
		return insert.getSavedId() != null;
	}

	@Override
	public boolean update(GoogleAccessToken token)
	{
		WriteResult<GoogleAccessToken, String> updateById = coll.updateById(token.getId(), token);
		return updateById.getN() == 1;
	}

	@Override
	public boolean remove(GoogleAccessToken token)
	{
		WriteResult<GoogleAccessToken, String> updateById = coll.removeById(token.getId());
		return updateById.getN() == 1;
	}
	
	
}
