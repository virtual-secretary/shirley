package models;

import java.lang.reflect.Field;

import org.mongojack.Id;
import org.mongojack.ObjectId;

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
	@ObjectId
	private String id;
	
	@JsonProperty
	private String accessToken;
	
	@JsonProperty
	private String tokenType;
	
	@JsonProperty
	private long expiresIn;
	
	@JsonProperty
	private String idToken;
	
	public GoogleAccessToken(){}
	
	public GoogleAccessToken(String id, String accessToken, String tokenType,
			long expiresIn, String idToken)
	{
		super();
		this.id = id;
		this.accessToken = accessToken;
		this.tokenType = tokenType;
		this.expiresIn = expiresIn;
		this.idToken = idToken;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
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
