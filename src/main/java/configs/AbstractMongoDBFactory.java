package configs;

import healthchecks.MongoHealthCheck;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import managed.MongoManaged;

import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.MongoOptions;
import com.mongodb.ServerAddress;
import com.yammer.dropwizard.config.Environment;

public abstract class AbstractMongoDBFactory
{
	private final Environment env;

    protected AbstractMongoDBFactory(Environment env) {
        this.env = env;
    }
    
    abstract void configureDAOFactory(final Mongo mongo, MongoConfiguration conf);

    public Mongo build(MongoConfiguration conf, String name) throws MongoException, UnknownHostException
    {
    	final MongoOptions options = getMongoOptions(conf);
    	final Mongo mongo = new Mongo(extractServerAddress(conf.getNodes()), options);
    	
    	env.manage(new MongoManaged(mongo));
    	env.addHealthCheck(new MongoHealthCheck(mongo, name));
    	return mongo;
    }
    
    private List<ServerAddress> extractServerAddress(List<MongoNode> nodes) throws UnknownHostException
    {
    	List<ServerAddress> addresses = new ArrayList<ServerAddress>(nodes.size());
    	
    	for ( MongoNode node : nodes )
    	{
    		addresses.add(node.getServerAddress());
    	}
    	return addresses;
    }
    
    private MongoOptions getMongoOptions(MongoConfiguration conf)
    {
    	MongoOptions opt = new MongoOptions();
    	opt.autoConnectRetry = conf.isAutoConnectRetry();
    	opt.connectionsPerHost = conf.getConnectionPerHost();
    	opt.connectTimeout = (int) conf.getConnectionTimeOut().toMilliseconds();
    	opt.description = conf.getDescription();
    	opt.fsync = conf.isFsync();
    	opt.j = conf.isJ();
    	opt.maxAutoConnectRetryTime = conf.getMaxAutoConnectRetryTime().toMilliseconds();
    	opt.maxWaitTime = (int) conf.getMaxWaitTime().toMilliseconds();
    	opt.safe = conf.isSafe();
    	opt.socketKeepAlive = conf.isSocketKeepAlive();
    	opt.socketTimeout = (int) conf.getSocketTimeout().toMilliseconds();
    	opt.threadsAllowedToBlockForConnectionMultiplier = conf.getThreadsAllowedToBlockForConnectionMultiplier();
    	opt.w = conf.getW();
    	opt.wtimeout = (int) conf.getWtimeout().toMilliseconds();
    	return opt;
    }
}
