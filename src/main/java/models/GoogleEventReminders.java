package models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class GoogleEventReminders
{
	@JsonProperty private boolean userDefault;
	@JsonProperty private List<GoogleReminder> overrides;
	
	public GoogleEventReminders(){}
	
	public GoogleEventReminders(boolean userDefault,
			List<GoogleReminder> overrides)
	{
		super();
		this.userDefault = userDefault;
		this.overrides = overrides;
	}

	public boolean isUserDefault()
	{
		return userDefault;
	}

	public void setUserDefault(boolean userDefault)
	{
		this.userDefault = userDefault;
	}

	public List<GoogleReminder> getOverrides()
	{
		return overrides;
	}

	public void setOverrides(List<GoogleReminder> overrides)
	{
		this.overrides = overrides;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((overrides == null) ? 0 : overrides.hashCode());
		result = prime * result + (userDefault ? 1231 : 1237);
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
		GoogleEventReminders other = (GoogleEventReminders) obj;
		if (overrides == null)
		{
			if (other.overrides != null)
				return false;
		} else if (!overrides.equals(other.overrides))
			return false;
		if (userDefault != other.userDefault)
			return false;
		return true;
	}
	
}
