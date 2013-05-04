package service;

import resources.HelloWorldResource;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

import configs.ShirleyConfiguration;

public class ShirleyService extends Service<ShirleyConfiguration>
{

	@Override
	public void initialize(Bootstrap<ShirleyConfiguration> bootstrap)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run(ShirleyConfiguration conf, Environment env)
			throws Exception
	{
		// TODO Auto-generated method stub
		env.addResource(new HelloWorldResource());
	}

}
