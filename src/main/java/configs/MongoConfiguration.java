package configs;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.util.Duration;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MongoConfiguration
{
	@JsonProperty("database")
	private String database = "appfuel";

	@JsonProperty("setUpIndex")
	private boolean setUpIndex = false;

	@JsonProperty("nodes")
	private List<MongoNode> nodes;

	@JsonProperty("description")
	private String description = "default mongo";

	@JsonProperty("connectionPerHost")
	private int connectionPerHost = 10;

	@JsonProperty("threadsAllowedToBlockForConnectionMultiplier")
	private int threadsAllowedToBlockForConnectionMultiplier = 5;

	@JsonProperty("maxWaitTime")
	private Duration maxWaitTime = Duration.minutes(2);

	@JsonProperty("connectionTimeOut")
	private Duration connectionTimeOut = Duration.milliseconds(0);

	@JsonProperty("socketTimeout")
	private Duration socketTimeout = Duration.milliseconds(0);

	@JsonProperty("socketKeepAlive")
	private boolean socketKeepAlive = false;

	@JsonProperty("autoConnectRetry")
	private boolean autoConnectRetry = false;

	// if autoConnectRetry is true default is 15 s
	@JsonProperty("maxAutoConnectRetryTime ")
	private Duration maxAutoConnectRetryTime = Duration.milliseconds(0);

	@JsonProperty("safe")
	private boolean safe = false;

	@JsonProperty("w")
	private int w = 0;

	@JsonProperty("wtimeout")
	private Duration wtimeout = Duration.seconds(0);

	@JsonProperty("fsync")
	private boolean fsync = false;

	@JsonProperty("j")
	private boolean j = false;

	public boolean getSetUpIndex()
	{
		return setUpIndex;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getConnectionPerHost()
	{
		return connectionPerHost;
	}

	public void setConnectionPerHost(int connectionPerHost)
	{
		this.connectionPerHost = connectionPerHost;
	}

	public int getThreadsAllowedToBlockForConnectionMultiplier()
	{
		return threadsAllowedToBlockForConnectionMultiplier;
	}

	public void setThreadsAllowedToBlockForConnectionMultiplier(
			int threadsAllowedToBlockForConnectionMultiplier)
	{
		this.threadsAllowedToBlockForConnectionMultiplier = threadsAllowedToBlockForConnectionMultiplier;
	}

	public Duration getMaxWaitTime()
	{
		return maxWaitTime;
	}

	public void setMaxWaitTime(Duration maxWaitTime)
	{
		this.maxWaitTime = maxWaitTime;
	}

	public Duration getConnectionTimeOut()
	{
		return connectionTimeOut;
	}

	public void setConnectionTimeOut(Duration connectionTimeOut)
	{
		this.connectionTimeOut = connectionTimeOut;
	}

	public Duration getSocketTimeout()
	{
		return socketTimeout;
	}

	public void setSocketTimeout(Duration socketTimeout)
	{
		this.socketTimeout = socketTimeout;
	}

	public boolean isSocketKeepAlive()
	{
		return socketKeepAlive;
	}

	public void setSocketKeepAlive(boolean socketKeepAlive)
	{
		this.socketKeepAlive = socketKeepAlive;
	}

	public boolean isAutoConnectRetry()
	{
		return autoConnectRetry;
	}

	public void setAutoConnectRetry(boolean autoConnectRetry)
	{
		this.autoConnectRetry = autoConnectRetry;
	}

	public Duration getMaxAutoConnectRetryTime()
	{
		return maxAutoConnectRetryTime;
	}

	public void setMaxAutoConnectRetryTime(Duration maxAutoConnectRetryTime)
	{
		this.maxAutoConnectRetryTime = maxAutoConnectRetryTime;
	}

	public boolean isSafe()
	{
		return safe;
	}

	public void setSafe(boolean safe)
	{
		this.safe = safe;
	}

	public int getW()
	{
		return w;
	}

	public void setW(int w)
	{
		this.w = w;
	}

	public Duration getWtimeout()
	{
		return wtimeout;
	}

	public void setWtimeout(Duration wtimeout)
	{
		this.wtimeout = wtimeout;
	}

	public boolean isFsync()
	{
		return fsync;
	}

	public void setFsync(boolean fsync)
	{
		this.fsync = fsync;
	}

	public boolean isJ()
	{
		return j;
	}

	public void setJ(boolean j)
	{
		this.j = j;
	}

	public List<MongoNode> getNodes()
	{
		return nodes;
	}

	public String getDatabase()
	{
		return this.database;
	}
}
