package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class GoogleEventAttendee
{
	@JsonProperty private String id;
	@JsonProperty private String email;
	@JsonProperty private String displayName;
	@JsonProperty private boolean origanizer;
	@JsonProperty private boolean self;
	@JsonProperty private boolean resource;
	@JsonProperty private boolean optional;
	@JsonProperty private String responseStatus;
	@JsonProperty private String comment;
	@JsonProperty private int additionalGuests;
	
	public GoogleEventAttendee(){}
	
	public GoogleEventAttendee(String id, String email, String displayName,
			boolean origanizer, boolean self, boolean resource,
			boolean optional, String responseStatus, String comment,
			int additionalGuests)
	{
		super();
		this.id = id;
		this.email = email;
		this.displayName = displayName;
		this.origanizer = origanizer;
		this.self = self;
		this.resource = resource;
		this.optional = optional;
		this.responseStatus = responseStatus;
		this.comment = comment;
		this.additionalGuests = additionalGuests;
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

	public String getDisplayName()
	{
		return displayName;
	}

	public void setDisplayName(String displayName)
	{
		this.displayName = displayName;
	}

	public boolean isOriganizer()
	{
		return origanizer;
	}

	public void setOriganizer(boolean origanizer)
	{
		this.origanizer = origanizer;
	}

	public boolean isSelf()
	{
		return self;
	}

	public void setSelf(boolean self)
	{
		this.self = self;
	}

	public boolean isResource()
	{
		return resource;
	}

	public void setResource(boolean resource)
	{
		this.resource = resource;
	}

	public boolean isOptional()
	{
		return optional;
	}

	public void setOptional(boolean optional)
	{
		this.optional = optional;
	}

	public String getResponseStatus()
	{
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus)
	{
		this.responseStatus = responseStatus;
	}

	public String getComment()
	{
		return comment;
	}

	public void setComment(String comment)
	{
		this.comment = comment;
	}

	public int getAdditionalGuests()
	{
		return additionalGuests;
	}

	public void setAdditionalGuests(int additionalGuests)
	{
		this.additionalGuests = additionalGuests;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + additionalGuests;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result
				+ ((displayName == null) ? 0 : displayName.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (optional ? 1231 : 1237);
		result = prime * result + (origanizer ? 1231 : 1237);
		result = prime * result + (resource ? 1231 : 1237);
		result = prime * result
				+ ((responseStatus == null) ? 0 : responseStatus.hashCode());
		result = prime * result + (self ? 1231 : 1237);
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
		GoogleEventAttendee other = (GoogleEventAttendee) obj;
		if (additionalGuests != other.additionalGuests)
			return false;
		if (comment == null)
		{
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (displayName == null)
		{
			if (other.displayName != null)
				return false;
		} else if (!displayName.equals(other.displayName))
			return false;
		if (email == null)
		{
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (optional != other.optional)
			return false;
		if (origanizer != other.origanizer)
			return false;
		if (resource != other.resource)
			return false;
		if (responseStatus == null)
		{
			if (other.responseStatus != null)
				return false;
		} else if (!responseStatus.equals(other.responseStatus))
			return false;
		if (self != other.self)
			return false;
		return true;
	}
	
	
}
