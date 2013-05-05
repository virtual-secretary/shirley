package managed;

import com.mongodb.Mongo;
import com.yammer.dropwizard.lifecycle.Managed;

public class MongoManaged implements Managed
{
	private final Mongo mongo;
	
	public MongoManaged(Mongo mongo)
	{
		this.mongo = mongo;
	}

	@Override
	public void start() throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() throws Exception
	{
		mongo.close();
	}

}
