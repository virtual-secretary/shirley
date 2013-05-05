package service;

import java.net.URI;

import resources.EventsResource;
import resources.GoogleOAuthResource;
import resources.LinkedInResource;
import resources.RootResource;
import resources.TwitterResource;
import resources.YammerResource;
import security.LoginCookieGeneratorIpml;
import security.UAuthAuthenticator;
import security.User;
import security.UserAuthProvider;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import bundle.MongoExceptionsBundle;
import clients.GoogleClient;
import clients.GoogleClientImpl;
import clients.YammerClient;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.sun.jersey.api.client.Client;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.client.JerseyClientBuilder;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

import configs.MongoDBFactory;
import configs.ShirleyConfiguration;
import daos.GoogleAccessTokenDAO;
import daos.LinkedInRequestTokenDAO;
import daos.LoginTokenDAO;
import daos.MongoGoogleAccessTokenDAO;
import daos.MongoLinkedInAccessTokenDAO;
import daos.MongoLinkedInRequestTokenDAO;
import daos.MongoLoginTokenDAO;
import daos.MongoTwitterAccessTokenDAO;
import daos.MongoTwitterRequestTokenDAO;
import daos.MongoUserDAO;
import daos.TwitterAccessTokenDAO;
import daos.TwitterRequestTokenDAO;
import daos.UserDAO;

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
		
		// JerseyClient
		final Client client = new JerseyClientBuilder().using(conf.getJerseyClientConfiguration())
													   .using(env)
													   .build();
		
		// Google Clients
		GoogleClient gClient = new GoogleClientImpl(client);
		
		// TwitterClient
		Twitter twitter = TwitterFactory.getSingleton();
		twitter.setOAuthConsumer("0BRsjcxPE3snL06eqXW8A", "zdRP1SBSsH08jArP4UM39imiynRa9KdYuDGatw6c");
		
		// YammerClient
		YammerClient yClient = new YammerClient(client);
		
		// LoginCookie Generator
		LoginCookieGeneratorIpml generator = new LoginCookieGeneratorIpml(db, serverURI);
		
		// DAO
		TwitterAccessTokenDAO tatDAO = new MongoTwitterAccessTokenDAO(db);
		TwitterRequestTokenDAO trtDAO = new MongoTwitterRequestTokenDAO(db);
		GoogleAccessTokenDAO gatDAO = new MongoGoogleAccessTokenDAO(db);
		LinkedInRequestTokenDAO lrtDAO = new MongoLinkedInRequestTokenDAO(db);
		MongoLinkedInAccessTokenDAO ltaDAO = new MongoLinkedInAccessTokenDAO(db);
		LoginTokenDAO ltDAO = new MongoLoginTokenDAO(m, db.getName());
		UserDAO userDAO = new MongoUserDAO(m, db.getName());
		
		
		// Adding Authenticator
		env.addProvider(new UserAuthProvider<User>(new UAuthAuthenticator(m, db), serverURI.toString()));
		
		// Adding Resources
		env.addResource(new RootResource(db, generator));
		env.addResource(new LinkedInResource(serverURI, userDAO, lrtDAO, ltaDAO));
		env.addResource(new TwitterResource(serverURI, twitter, userDAO, trtDAO, tatDAO));
		env.addResource(new GoogleOAuthResource(serverURI, gClient, gatDAO, userDAO));
		env.addResource(new EventsResource(gClient, gatDAO));
		env.addResource(new YammerResource(serverURI, yClient, userDAO, db));
	}

}
