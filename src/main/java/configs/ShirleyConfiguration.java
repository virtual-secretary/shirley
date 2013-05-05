package configs;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.client.JerseyClientConfiguration;
import com.yammer.dropwizard.config.Configuration;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ShirleyConfiguration extends Configuration
{
	@JsonProperty
	private URI serverName;
	
	@JsonProperty
	private JerseyClientConfiguration httpClient = new JerseyClientConfiguration();
	
	@JsonProperty
	private MongoConfiguration mongo = new MongoConfiguration();
	
	public JerseyClientConfiguration getJerseyClientConfiguration()
	{
		return httpClient;
	}

	public MongoConfiguration getMongoConfiguration()
	{
		return mongo;
	}

	public URI getServerURI()
	{
		return serverName;
	}
	
	
}
