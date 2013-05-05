package security;

import java.util.Date;
import java.util.List;

import models.UserSettings;

import org.mongojack.Id;
import org.mongojack.ObjectId;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class User
{
	@Id
	@ObjectId
	private String id;
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	private List<String> emails;
	
	@JsonProperty
	private String password;
	
	@JsonProperty 
	private UserSettings setting;
	
	@JsonProperty
	private Date created;
	
	@JsonProperty Date updated;
	
	public User(){}

	public User(String id, String name, List<String> emails, String password,
			UserSettings setting, Date created, Date updated)
	{
		super();
		this.id = id;
		this.name = name;
		this.emails = emails;
		this.password = password;
		this.setting = setting;
		this.created = created;
		this.updated = updated;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<String> getEmails()
	{
		return emails;
	}

	public void setEmails(List<String> emails)
	{
		this.emails = emails;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public UserSettings getSetting()
	{
		return setting;
	}

	public void setSetting(UserSettings setting)
	{
		this.setting = setting;
	}

	public Date getCreated()
	{
		return created;
	}

	public void setCreated(Date created)
	{
		this.created = created;
	}

	public Date getUpdated()
	{
		return updated;
	}

	public void setUpdated(Date updated)
	{
		this.updated = updated;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((emails == null) ? 0 : emails.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((setting == null) ? 0 : setting.hashCode());
		result = prime * result + ((updated == null) ? 0 : updated.hashCode());
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
		User other = (User) obj;
		if (created == null)
		{
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (emails == null)
		{
			if (other.emails != null)
				return false;
		} else if (!emails.equals(other.emails))
			return false;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null)
		{
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (setting == null)
		{
			if (other.setting != null)
				return false;
		} else if (!setting.equals(other.setting))
			return false;
		if (updated == null)
		{
			if (other.updated != null)
				return false;
		} else if (!updated.equals(other.updated))
			return false;
		return true;
	}	
	
	
}
