package healthchecks;

import com.mongodb.Mongo;
import com.yammer.metrics.core.HealthCheck;
import com.yammer.metrics.core.HealthCheck.Result;

public class MongoHealthCheck extends HealthCheck
{
	private final Mongo mongo;
	
	public MongoHealthCheck(Mongo mongo, String name)
	{
		super(name);
		this.mongo = mongo;
	}

	@Override
	public Result check() throws Exception
	{
		mongo.getDatabaseNames();
		return Result.healthy();
	}

}
