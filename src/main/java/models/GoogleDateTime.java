package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.api.client.util.DateTime;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class GoogleDateTime
{
	private final DateTime dateTime;

	@JsonCreator
	public GoogleDateTime(String value)
	{
		this.dateTime = new DateTime(value);
	}

	public DateTime getDateTime()
	{
		return dateTime;
	}
	
	@JsonValue
	public String getDateString()
	{
		return dateTime.toStringRfc3339();
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateTime == null) ? 0 : dateTime.hashCode());
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
		GoogleDateTime other = (GoogleDateTime) obj;
		if (dateTime == null)
		{
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		return true;
	}
	
	
	
	
}
