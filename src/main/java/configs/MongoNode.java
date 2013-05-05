package configs;

import java.net.UnknownHostException;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.ServerAddress;

@JsonIgnoreProperties(ignoreUnknown=true)
public class MongoNode
{
	@JsonProperty
	private String host;
	
	@JsonProperty
	private int port = 27017;
	
	public String getHost()
	{
		return host;
	}
	public void setHost(String host)
	{
		this.host = host;
	}
	public int getPort()
	{
		return port;
	}
	public void setPort(int port)
	{
		this.port = port;
	}
	
	@JsonIgnore
	public ServerAddress getServerAddress() throws UnknownHostException
	{
		return new ServerAddress(host, port);
	}
}	
