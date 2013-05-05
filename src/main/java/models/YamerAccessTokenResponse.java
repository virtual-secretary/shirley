package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.json.JsonSnakeCase;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonSnakeCase
public class YamerAccessTokenResponse
{
	@JsonProperty private YammerAccessToken accessToken;

	public YamerAccessTokenResponse()
	{}

	public YamerAccessTokenResponse(YammerAccessToken accessToken)
	{
		super();
		this.accessToken = accessToken;
	}

	public YammerAccessToken getAccessToken()
	{
		return accessToken;
	}

	public void setAccessToken(YammerAccessToken accessToken)
	{
		this.accessToken = accessToken;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accessToken == null) ? 0 : accessToken.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		YamerAccessTokenResponse other = (YamerAccessTokenResponse) obj;
		if (accessToken == null)
		{
			if (other.accessToken != null)
				return false;
		} else if (!accessToken.equals(other.accessToken))
			return false;
		return true;
	}
	
	
}
