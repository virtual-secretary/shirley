package models;

import java.util.Date;

import org.mongojack.Id;
import org.mongojack.ObjectId;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class LinkedInAccessToken
{
	@Id
	@ObjectId
	private String id;
	
	@JsonProperty
	private String token;
	
	@JsonProperty
	private String tokenSecret;
	
	@JsonProperty
	private Date expirationTime;
	
	public LinkedInAccessToken(){}

	
	public LinkedInAccessToken(String id, String token, String tokenSecret,
			Date expirationTime)
	{
		super();
		this.id = id;
		this.token = token;
		this.tokenSecret = tokenSecret;
		this.expirationTime = expirationTime;
	}


	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getToken()
	{
		return token;
	}

	public void setToken(String token)
	{
		this.token = token;
	}

	public String getTokenSecret()
	{
		return tokenSecret;
	}

	public void setTokenSecret(String tokenSecret)
	{
		this.tokenSecret = tokenSecret;
	}

	public Date getExpirationTime()
	{
		return expirationTime;
	}

	public void setExpirationTime(Date expirationTime)
	{
		this.expirationTime = expirationTime;
	}


	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((expirationTime == null) ? 0 : expirationTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result
				+ ((tokenSecret == null) ? 0 : tokenSecret.hashCode());
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
		LinkedInAccessToken other = (LinkedInAccessToken) obj;
		if (expirationTime == null)
		{
			if (other.expirationTime != null)
				return false;
		} else if (!expirationTime.equals(other.expirationTime))
			return false;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (token == null)
		{
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (tokenSecret == null)
		{
			if (other.tokenSecret != null)
				return false;
		} else if (!tokenSecret.equals(other.tokenSecret))
			return false;
		return true;
	}	
	
}