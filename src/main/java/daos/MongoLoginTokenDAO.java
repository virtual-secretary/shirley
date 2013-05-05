package daos;

import com.mongodb.Mongo;

import security.LoginToken;

public class MongoLoginTokenDAO extends MongoDAO<LoginToken> implements LoginTokenDAO
{
	public MongoLoginTokenDAO(Mongo mongo, String db)
	{
		super(mongo, db, "login_tokens", LoginToken.class);
	}

	@Override
	public void setUpIndex()
	{
		// TODO Auto-generated method stub
	}

}
