package bundle;

import com.yammer.dropwizard.Bundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class MongoExceptionsBundle implements Bundle
{

	@Override
	public void initialize(Bootstrap<?> bootstrap)
	{
		// Do nothing
	}

	@Override
	public void run(Environment env)
	{
		env.addProvider(new LoggingMongoExceptionMapper());
		env.addProvider(new MongoExceptionMapper());
	}

}
