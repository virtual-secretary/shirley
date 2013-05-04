package configs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.client.JerseyClientConfiguration;
import com.yammer.dropwizard.config.Configuration;

public class ShirleyConfiguration extends Configuration
{
	@JsonProperty
	private JerseyClientConfiguration httpClient = new JerseyClientConfiguration();
	
	public JerseyClientConfiguration getJerseyClientConfiguration()
	{
		return httpClient;
	}
}
