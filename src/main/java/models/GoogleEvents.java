package models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class GoogleEvents
{
	@JsonProperty private String kind;
	@JsonProperty private String etag;
	@JsonProperty private String summary;
	@JsonProperty private String description;
	@JsonProperty private GoogleDateTime updated;
	@JsonProperty private String timeZone;
	@JsonProperty private String accessRole;
	@JsonProperty private List<GoogleReminder> defaultReminders;
	@JsonProperty private String nextPageToken;
	@JsonProperty private List<GoogleEvent> items;
	
	public GoogleEvents(){}

	public GoogleEvents(String kind, String etag, String summary,
			String description, GoogleDateTime updated, String timeZone,
			String accessRole, List<GoogleReminder> defaultReminders,
			String nextPageToken, List<GoogleEvent> items)
	{
		super();
		this.kind = kind;
		this.etag = etag;
		this.summary = summary;
		this.description = description;
		this.updated = updated;
		this.timeZone = timeZone;
		this.accessRole = accessRole;
		this.defaultReminders = defaultReminders;
		this.nextPageToken = nextPageToken;
		this.items = items;
	}

	public String getKind()
	{
		return kind;
	}

	public void setKind(String kind)
	{
		this.kind = kind;
	}

	public String getEtag()
	{
		return etag;
	}

	public void setEtag(String etag)
	{
		this.etag = etag;
	}

	public String getSummary()
	{
		return summary;
	}

	public void setSummary(String summary)
	{
		this.summary = summary;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public GoogleDateTime getUpdated()
	{
		return updated;
	}

	public void setUpdated(GoogleDateTime updated)
	{
		this.updated = updated;
	}

	public String getTimeZone()
	{
		return timeZone;
	}

	public void setTimeZone(String timeZone)
	{
		this.timeZone = timeZone;
	}

	public String getAccessRole()
	{
		return accessRole;
	}

	public void setAccessRole(String accessRole)
	{
		this.accessRole = accessRole;
	}

	public List<GoogleReminder> getDefaultReminders()
	{
		return defaultReminders;
	}

	public void setDefaultReminders(List<GoogleReminder> defaultReminders)
	{
		this.defaultReminders = defaultReminders;
	}

	public String getNextPageToken()
	{
		return nextPageToken;
	}

	public void setNextPageToken(String nextPageToken)
	{
		this.nextPageToken = nextPageToken;
	}

	public List<GoogleEvent> getItems()
	{
		return items;
	}

	public void setItems(List<GoogleEvent> items)
	{
		this.items = items;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accessRole == null) ? 0 : accessRole.hashCode());
		result = prime
				* result
				+ ((defaultReminders == null) ? 0 : defaultReminders.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((etag == null) ? 0 : etag.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((kind == null) ? 0 : kind.hashCode());
		result = prime * result
				+ ((nextPageToken == null) ? 0 : nextPageToken.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		result = prime * result
				+ ((timeZone == null) ? 0 : timeZone.hashCode());
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
		GoogleEvents other = (GoogleEvents) obj;
		if (accessRole == null)
		{
			if (other.accessRole != null)
				return false;
		} else if (!accessRole.equals(other.accessRole))
			return false;
		if (defaultReminders == null)
		{
			if (other.defaultReminders != null)
				return false;
		} else if (!defaultReminders.equals(other.defaultReminders))
			return false;
		if (description == null)
		{
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (etag == null)
		{
			if (other.etag != null)
				return false;
		} else if (!etag.equals(other.etag))
			return false;
		if (items == null)
		{
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (kind == null)
		{
			if (other.kind != null)
				return false;
		} else if (!kind.equals(other.kind))
			return false;
		if (nextPageToken == null)
		{
			if (other.nextPageToken != null)
				return false;
		} else if (!nextPageToken.equals(other.nextPageToken))
			return false;
		if (summary == null)
		{
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		if (timeZone == null)
		{
			if (other.timeZone != null)
				return false;
		} else if (!timeZone.equals(other.timeZone))
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
