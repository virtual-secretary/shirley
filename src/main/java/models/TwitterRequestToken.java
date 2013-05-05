package models;

import org.mongojack.Id;
import org.mongojack.ObjectId;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class TwitterRequestToken
{
	@Id @ObjectId private String id;
	@JsonProperty private String token;
	@JsonProperty private String tokenSecret;
	@JsonProperty private String authorizationURL;
	@JsonProperty private String authenticationURL;
	
	public TwitterRequestToken(){}
	
	public TwitterRequestToken(String id, String token, String tokenSecret,
			String authorizationURL, String authenticationURL)
	{
		super();
		this.id = id;
		this.token = token;
		this.tokenSecret = tokenSecret;
		this.authorizationURL = authorizationURL;
		this.authenticationURL = authenticationURL;
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

	public String getAuthorizationURL()
	{
		return authorizationURL;
	}

	public void setAuthorizationURL(String authorizationURL)
	{
		this.authorizationURL = authorizationURL;
	}

	public String getAuthenticationURL()
	{
		return authenticationURL;
	}

	public void setAuthenticationURL(String authenticationURL)
	{
		this.authenticationURL = authenticationURL;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((authenticationURL == null) ? 0 : authenticationURL
						.hashCode());
		result = prime
				* result
				+ ((authorizationURL == null) ? 0 : authorizationURL.hashCode());
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
		TwitterRequestToken other = (TwitterRequestToken) obj;
		if (authenticationURL == null)
		{
			if (other.authenticationURL != null)
				return false;
		} else if (!authenticationURL.equals(other.authenticationURL))
			return false;
		if (authorizationURL == null)
		{
			if (other.authorizationURL != null)
				return false;
		} else if (!authorizationURL.equals(other.authorizationURL))
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
