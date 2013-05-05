package models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class GoogleCalendarEntity
{
	@JsonProperty
	private String kind;
	
	@JsonProperty
	private String etag;
	
	@JsonProperty
	private String id;
	
	@JsonProperty
	private String summary;
	
	@JsonProperty
	private String description;
	
	@JsonProperty
	private String timeZone;
	
	@JsonProperty
	private String summaryOverride;
	
	@JsonProperty
	private String colorId;
	
	@JsonProperty
	private String backgroundColor;
	
	@JsonProperty
	private String foregroundColor;
	
	@JsonProperty
	private boolean hidden;
	
	@JsonProperty
	private boolean selected;
	
	@JsonProperty
	private String accessRole;
	
	@JsonProperty
	private List<GoogleReminder> defaultReminders;

	public GoogleCalendarEntity()
	{
		super();
	}

	public GoogleCalendarEntity(String kind, String etag, String id,
			String summary, String description, String timeZone,
			String summaryOverride, String colorId, String backgroundColor,
			String foregroundColor, boolean hidden, boolean selected,
			String accessRole, List<GoogleReminder> defaultReminders)
	{
		super();
		this.kind = kind;
		this.etag = etag;
		this.id = id;
		this.summary = summary;
		this.description = description;
		this.timeZone = timeZone;
		this.summaryOverride = summaryOverride;
		this.colorId = colorId;
		this.backgroundColor = backgroundColor;
		this.foregroundColor = foregroundColor;
		this.hidden = hidden;
		this.selected = selected;
		this.accessRole = accessRole;
		this.defaultReminders = defaultReminders;
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

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
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

	public String getTimeZone()
	{
		return timeZone;
	}

	public void setTimeZone(String timeZone)
	{
		this.timeZone = timeZone;
	}

	public String getSummaryOverride()
	{
		return summaryOverride;
	}

	public void setSummaryOverride(String summaryOverride)
	{
		this.summaryOverride = summaryOverride;
	}

	public String getColorId()
	{
		return colorId;
	}

	public void setColorId(String colorId)
	{
		this.colorId = colorId;
	}

	public String getBackgroundColor()
	{
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor)
	{
		this.backgroundColor = backgroundColor;
	}

	public String getForegroundColor()
	{
		return foregroundColor;
	}

	public void setForegroundColor(String foregroundColor)
	{
		this.foregroundColor = foregroundColor;
	}

	public boolean isHidden()
	{
		return hidden;
	}

	public void setHidden(boolean hidden)
	{
		this.hidden = hidden;
	}

	public boolean isSelected()
	{
		return selected;
	}

	public void setSelected(boolean selected)
	{
		this.selected = selected;
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

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accessRole == null) ? 0 : accessRole.hashCode());
		result = prime * result
				+ ((backgroundColor == null) ? 0 : backgroundColor.hashCode());
		result = prime * result + ((colorId == null) ? 0 : colorId.hashCode());
		result = prime
				* result
				+ ((defaultReminders == null) ? 0 : defaultReminders.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((etag == null) ? 0 : etag.hashCode());
		result = prime * result
				+ ((foregroundColor == null) ? 0 : foregroundColor.hashCode());
		result = prime * result + (hidden ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((kind == null) ? 0 : kind.hashCode());
		result = prime * result + (selected ? 1231 : 1237);
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		result = prime * result
				+ ((summaryOverride == null) ? 0 : summaryOverride.hashCode());
		result = prime * result
				+ ((timeZone == null) ? 0 : timeZone.hashCode());
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
		GoogleCalendarEntity other = (GoogleCalendarEntity) obj;
		if (accessRole == null)
		{
			if (other.accessRole != null)
				return false;
		} else if (!accessRole.equals(other.accessRole))
			return false;
		if (backgroundColor == null)
		{
			if (other.backgroundColor != null)
				return false;
		} else if (!backgroundColor.equals(other.backgroundColor))
			return false;
		if (colorId == null)
		{
			if (other.colorId != null)
				return false;
		} else if (!colorId.equals(other.colorId))
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
		if (foregroundColor == null)
		{
			if (other.foregroundColor != null)
				return false;
		} else if (!foregroundColor.equals(other.foregroundColor))
			return false;
		if (hidden != other.hidden)
			return false;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (kind == null)
		{
			if (other.kind != null)
				return false;
		} else if (!kind.equals(other.kind))
			return false;
		if (selected != other.selected)
			return false;
		if (summary == null)
		{
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		if (summaryOverride == null)
		{
			if (other.summaryOverride != null)
				return false;
		} else if (!summaryOverride.equals(other.summaryOverride))
			return false;
		if (timeZone == null)
		{
			if (other.timeZone != null)
				return false;
		} else if (!timeZone.equals(other.timeZone))
			return false;
		return true;
	}
	
	
	
	
}
