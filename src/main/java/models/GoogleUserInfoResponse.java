package models;

import java.lang.reflect.Field;
import java.net.URI;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import com.yammer.dropwizard.json.JsonSnakeCase;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonSnakeCase
public class GoogleUserInfoResponse
{
	@JsonProperty
	private String id;

	@JsonProperty
	private String email;

	@JsonProperty
	private boolean verifiedEmail;

	@JsonProperty
	private String name;

	@JsonProperty
	private String givenName;

	@JsonProperty
	private String familyName;

	@JsonProperty
	private URI link;

	@JsonProperty
	private Gender gender;

	@JsonProperty
	private Locale locale;

	public GoogleUserInfoResponse()
	{
	}

	public GoogleUserInfoResponse(String id, String email,
			boolean verifiedEmail, String name, String givenName,
			String familyName, URI link, Gender gender, Locale locale)
	{
		super();
		this.id = id;
		this.email = email;
		this.verifiedEmail = verifiedEmail;
		this.name = name;
		this.givenName = givenName;
		this.familyName = familyName;
		this.link = link;
		this.gender = gender;
		this.locale = locale;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public boolean isVerifiedEmail()
	{
		return verifiedEmail;
	}

	public void setVerifiedEmail(boolean verifiedEmail)
	{
		this.verifiedEmail = verifiedEmail;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getGivenName()
	{
		return givenName;
	}

	public void setGivenName(String givenName)
	{
		this.givenName = givenName;
	}

	public String getFamilyName()
	{
		return familyName;
	}

	public void setFamilyName(String familyName)
	{
		this.familyName = familyName;
	}

	public URI getLink()
	{
		return link;
	}

	public void setLink(URI link)
	{
		this.link = link;
	}

	public Gender getGender()
	{
		return gender;
	}

	public void setGender(Gender gender)
	{
		this.gender = gender;
	}

	public Locale getLocale()
	{
		return locale;
	}

	public void setLocale(Locale locale)
	{
		this.locale = locale;
	}

	@Override
	public boolean equals(Object other)
	{
		if (other == null)
			return false;
		if (this == other)
			return true;
		if (this.getClass() != other.getClass())
			return false;

		Field[] fields = GoogleUserInfoResponse.class.getDeclaredFields();

		try
		{
			for (Field f : fields)
			{
				if (!Objects.equal(f.get(this), f.get(other)))
				{
					return false;
				}
			}
		} catch (IllegalArgumentException e)
		{
			return false;
		} catch (IllegalAccessException e)
		{
			return false;
		}
		return true;
	}
}
