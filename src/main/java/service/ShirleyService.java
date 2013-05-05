package service;

import java.net.URI;

import resources.HelloWorldResource;
import resources.RootResource;
import security.LoginCookieGeneratorIpml;
import bundle.MongoExceptionsBundle;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

import configs.MongoDBFactory;
import configs.ShirleyConfiguration;

public class ShirleyService extends Service<ShirleyConfiguration>
{

	@Override
	public void initialize(Bootstrap<ShirleyConfiguration> bootstrap)
	{
		// TODO Auto-generated method stub
		bootstrap.addBundle(new MongoExceptionsBundle());
	}

	@Override
	public void run(ShirleyConfiguration conf, Environment env)
			throws Exception
	{
		
		// TODO Auto-generated method stub
		final Mongo m = new MongoDBFactory(env).build(conf.getMongoConfiguration(), "mongo");
		final DB db = m.getDB(conf.getMongoConfiguration().getDatabase());
		
		final URI serverURI = conf.getServerURI();
		
		// LoginCookie Generator
		LoginCookieGeneratorIpml generator = new LoginCookieGeneratorIpml(m, db, serverURI);
		
		// Adding Resources
		env.addResource(new HelloWorldResource());
		env.addResource(new RootResource(db, generator));
	}

}
