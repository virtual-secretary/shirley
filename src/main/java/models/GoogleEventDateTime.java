package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.api.client.util.DateTime;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class GoogleEventDateTime
{
	@JsonProperty private final DateTime date;
	@JsonProperty private final DateTime dateTime;
	@JsonProperty private final String timezone;
	
	@JsonCreator
	public GoogleEventDateTime(
			@JsonProperty("date") String date, 
			@JsonProperty("dateTime") String dateTime, 
			@JsonProperty("timezone") String timezone)
	{
		this.date = date == null || date.isEmpty() ? null : new DateTime(date);
		this.dateTime = dateTime == null || dateTime.isEmpty() ? null : new DateTime(dateTime);
		this.timezone = timezone;
	}

	public DateTime getDate()
	{
		return date;
	}

	public DateTime getDateTime()
	{
		return dateTime;
	}

	public String getTimezone()
	{
		return timezone;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result
				+ ((timezone == null) ? 0 : timezone.hashCode());
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
		GoogleEventDateTime other = (GoogleEventDateTime) obj;
		if (date == null)
		{
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (dateTime == null)
		{
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (timezone == null)
		{
			if (other.timezone != null)
				return false;
		} else if (!timezone.equals(other.timezone))
			return false;
		return true;
	}
	
}
