package models;

import java.lang.reflect.Field;

import org.mongojack.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class GoogleAccessToken
{
	@Id
	@JsonProperty
	private String developer;
	
	@JsonProperty
	private String accessToken;
	
	@JsonProperty
	private String tokenType;
	
	@JsonProperty
	private long expiresIn;
	
	@JsonProperty
	private String idToken;
	
	public GoogleAccessToken(){}
	
	public GoogleAccessToken(String developer, String accessToken,
			String tokenType, long expiresIn, String idToken)
	{
		super();
		this.developer = developer;
		this.accessToken = accessToken;
		this.tokenType = tokenType;
		this.expiresIn = expiresIn;
		this.idToken = idToken;
	}

	public String getDeveloper()
	{
		return developer;
	}

	public void setDeveloper(String developer)
	{
		this.developer = developer;
	}

	public String getAccessToken()
	{
		return accessToken;
	}

	public void setAccessToken(String accessToken)
	{
		this.accessToken = accessToken;
	}

	public String getTokenType()
	{
		return tokenType;
	}

	public void setTokenType(String tokenType)
	{
		this.tokenType = tokenType;
	}

	public long getExpiresIn()
	{
		return expiresIn;
	}

	public void setExpiresIn(long expiresIn)
	{
		this.expiresIn = expiresIn;
	}

	public String getIdToken()
	{
		return idToken;
	}

	public void setIdToken(String idToken)
	{
		this.idToken = idToken;
	}

	@Override
	public boolean equals(Object other)
	{
		if ( other == null ) return false;
		if ( this == other ) return true;
		if ( this.getClass() != other.getClass() ) return false;
		
		Field[] fields = GoogleAccessToken.class.getDeclaredFields();
		
		try
		{
			for ( Field f : fields )
			{
				if ( !Objects.equal(f.get(this), f.get(other) ) )
				{
					return false;
				}
			}
		}
		catch (IllegalArgumentException e)
		{
			return false;
		}
		catch (IllegalAccessException e)
		{
			return false;
		}
		return true;
	}
}
