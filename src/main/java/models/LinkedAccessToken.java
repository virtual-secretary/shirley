package models;

import java.lang.reflect.Field;

import org.mongojack.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.google.common.base.Objects;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class LinkedAccessToken
{
	@Id
	@JsonProperty
	private String developer;
	
	@JsonProperty
	private String accessToken;
	
	@JsonProperty
	private int verifier;
	
	@JsonProperty
	private String tokenType;
	
	@JsonProperty
	private long expiresIn;
	
	@JsonProperty
	private String idToken;
	
	public LinkedAccessToken(){}
	
	public LinkedAccessToken(String accessToken, int verifier,
			String tokenType, long expiresIn, String idToken)
	{
		super();
		this.accessToken = accessToken;
		this.verifier = verifier;
		this.tokenType = tokenType;
		this.expiresIn = expiresIn;
		this.idToken = idToken;
	}

	public String getAccessToken()
	{
		return accessToken;
	}

	public void setAccessToken(String accessToken)
	{
		this.accessToken = accessToken;
	}

	public int getVerifier()
	{
		return verifier;
	}

	public void setVerifier(int verifier)
	{
		this.verifier = verifier;
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
		
		Field[] fields = LinkedInAccessToken.class.getDeclaredFields();
		
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
