package daos;

import java.util.Date;

import org.mongojack.DBUpdate;
import org.mongojack.WriteResult;

import security.User;

import com.mongodb.Mongo;

public class MongoUserDAO extends MongoDAO<User> implements UserDAO
{
	public MongoUserDAO(Mongo mongo, String db)
	{
		super(mongo, db, "users", User.class);
	}

	@Override
	public void setUpIndex()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean updateSetting(User user)
	{
		WriteResult<User, String> updateById = jackColl.updateById(user.getId(), DBUpdate.set("setting", user.getSetting()).set("updated", new Date()));
		return updateById.getN() == 1;
	}

}
