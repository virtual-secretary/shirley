package models;

import org.mongojack.Id;
import org.mongojack.ObjectId;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.json.JsonSnakeCase;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonSnakeCase
public class YammerAccessToken 
{
	@Id
	@ObjectId
	private String id;
	
	@JsonProperty
	private String token;
	
	@JsonProperty
	private String expireAt;

	public YammerAccessToken(){}
	
	public YammerAccessToken(String token, String expireAt)
	{
		super();
		this.token = token;
		this.expireAt = expireAt;
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

	public String getExpireAt()
	{
		return expireAt;
	}

	public void setExpireAt(String expireAt)
	{
		this.expireAt = expireAt;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((expireAt == null) ? 0 : expireAt.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
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
		YammerAccessToken other = (YammerAccessToken) obj;
		if (expireAt == null)
		{
			if (other.expireAt != null)
				return false;
		} else if (!expireAt.equals(other.expireAt))
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
		return true;
	}

	
	
	
}
