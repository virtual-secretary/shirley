package configs;

import com.mongodb.Mongo;
import com.yammer.dropwizard.config.Environment;

public class MongoDBFactory extends AbstractMongoDBFactory
{
	public MongoDBFactory(Environment env)
	{
		super(env);
	}

	@Override
	public void configureDAOFactory(final Mongo mongo, final MongoConfiguration conf)
	{
		// EMPTY for now
	}
	
}
