package models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class GoogleEvent
{
	@JsonProperty private String kind;
	@JsonProperty private String etag;
	@JsonProperty private String id;
	@JsonProperty private String htmlLink;
	@JsonProperty private GoogleDateTime created;
	@JsonProperty private GoogleDateTime updated;
	@JsonProperty private String summary;
	@JsonProperty private String description;
	@JsonProperty private String location;
	@JsonProperty private String colorId;
	@JsonProperty private GoogleEventCreator creator;
	@JsonProperty private GoogleEventOrganizer origanizer;
	@JsonProperty private GoogleEventDateTime start;
	@JsonProperty private GoogleEventDateTime end;
	@JsonProperty private List<String> recurrence;
	@JsonProperty private String recurringEventId;
	@JsonProperty private GoogleEventDateTime originalStartTime;
	@JsonProperty private String transparency;
	@JsonProperty private String visibility;
	@JsonProperty private String iCalUID;
	@JsonProperty private int sequence;
	@JsonProperty private List<GoogleEventAttendee> attendees;
	@JsonProperty private boolean attendeesOmitted;
	@JsonProperty private GoogleEventGadget gadget;
	@JsonProperty private boolean anyoneCanAddSelf;
	@JsonProperty private boolean guestsCanInviteOthers;
	@JsonProperty private boolean guestsCanSeeOtherGuests;
	@JsonProperty private boolean privateCopy;
	@JsonProperty private GoogleEventReminders reminders;
	@JsonProperty private boolean endTimeUnspecified;
	@JsonProperty private boolean locked;
	@JsonProperty private String hangoutLink;
	
	public GoogleEvent(){}

	public GoogleEvent(String kind, String etag, String id, String htmlLink,
			GoogleDateTime created, GoogleDateTime updated, String summary,
			String description, String location, String colorId,
			GoogleEventCreator creator, GoogleEventOrganizer origanizer,
			GoogleEventDateTime start, GoogleEventDateTime end,
			List<String> recurrence, String recurringEventId,
			GoogleEventDateTime originalStartTime, String transparency,
			String visibility, String iCalUID, int sequence,
			List<GoogleEventAttendee> attendees, boolean attendeesOmitted,
			GoogleEventGadget gadget, boolean anyoneCanAddSelf,
			boolean guestsCanInviteOthers, boolean guestsCanSeeOtherGuests,
			boolean privateCopy, GoogleEventReminders reminders,
			boolean endTimeUnspecified, boolean locked, String hangoutLink)
	{
		super();
		this.kind = kind;
		this.etag = etag;
		this.id = id;
		this.htmlLink = htmlLink;
		this.created = created;
		this.updated = updated;
		this.summary = summary;
		this.description = description;
		this.location = location;
		this.colorId = colorId;
		this.creator = creator;
		this.origanizer = origanizer;
		this.start = start;
		this.end = end;
		this.recurrence = recurrence;
		this.recurringEventId = recurringEventId;
		this.originalStartTime = originalStartTime;
		this.transparency = transparency;
		this.visibility = visibility;
		this.iCalUID = iCalUID;
		this.sequence = sequence;
		this.attendees = attendees;
		this.attendeesOmitted = attendeesOmitted;
		this.gadget = gadget;
		this.anyoneCanAddSelf = anyoneCanAddSelf;
		this.guestsCanInviteOthers = guestsCanInviteOthers;
		this.guestsCanSeeOtherGuests = guestsCanSeeOtherGuests;
		this.privateCopy = privateCopy;
		this.reminders = reminders;
		this.endTimeUnspecified = endTimeUnspecified;
		this.locked = locked;
		this.hangoutLink = hangoutLink;
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

	public String getHtmlLink()
	{
		return htmlLink;
	}

	public void setHtmlLink(String htmlLink)
	{
		this.htmlLink = htmlLink;
	}

	public GoogleDateTime getCreated()
	{
		return created;
	}

	public void setCreated(GoogleDateTime created)
	{
		this.created = created;
	}

	public GoogleDateTime getUpdated()
	{
		return updated;
	}

	public void setUpdated(GoogleDateTime updated)
	{
		this.updated = updated;
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

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

	public String getColorId()
	{
		return colorId;
	}

	public void setColorId(String colorId)
	{
		this.colorId = colorId;
	}

	public GoogleEventCreator getCreator()
	{
		return creator;
	}

	public void setCreator(GoogleEventCreator creator)
	{
		this.creator = creator;
	}

	public GoogleEventOrganizer getOriganizer()
	{
		return origanizer;
	}

	public void setOriganizer(GoogleEventOrganizer origanizer)
	{
		this.origanizer = origanizer;
	}

	public GoogleEventDateTime getStart()
	{
		return start;
	}

	public void setStart(GoogleEventDateTime start)
	{
		this.start = start;
	}

	public GoogleEventDateTime getEnd()
	{
		return end;
	}

	public void setEnd(GoogleEventDateTime end)
	{
		this.end = end;
	}

	public List<String> getRecurrence()
	{
		return recurrence;
	}

	public void setRecurrence(List<String> recurrence)
	{
		this.recurrence = recurrence;
	}

	public String getRecurringEventId()
	{
		return recurringEventId;
	}

	public void setRecurringEventId(String recurringEventId)
	{
		this.recurringEventId = recurringEventId;
	}

	public GoogleEventDateTime getOriginalStartTime()
	{
		return originalStartTime;
	}

	public void setOriginalStartTime(GoogleEventDateTime originalStartTime)
	{
		this.originalStartTime = originalStartTime;
	}

	public String getTransparency()
	{
		return transparency;
	}

	public void setTransparency(String transparency)
	{
		this.transparency = transparency;
	}

	public String getVisibility()
	{
		return visibility;
	}

	public void setVisibility(String visibility)
	{
		this.visibility = visibility;
	}

	public String getiCalUID()
	{
		return iCalUID;
	}

	public void setiCalUID(String iCalUID)
	{
		this.iCalUID = iCalUID;
	}

	public int getSequence()
	{
		return sequence;
	}

	public void setSequence(int sequence)
	{
		this.sequence = sequence;
	}

	public List<GoogleEventAttendee> getAttendees()
	{
		return attendees;
	}

	public void setAttendees(List<GoogleEventAttendee> attendees)
	{
		this.attendees = attendees;
	}

	public boolean isAttendeesOmitted()
	{
		return attendeesOmitted;
	}

	public void setAttendeesOmitted(boolean attendeesOmitted)
	{
		this.attendeesOmitted = attendeesOmitted;
	}

	public GoogleEventGadget getGadget()
	{
		return gadget;
	}

	public void setGadget(GoogleEventGadget gadget)
	{
		this.gadget = gadget;
	}

	public boolean isAnyoneCanAddSelf()
	{
		return anyoneCanAddSelf;
	}

	public void setAnyoneCanAddSelf(boolean anyoneCanAddSelf)
	{
		this.anyoneCanAddSelf = anyoneCanAddSelf;
	}

	public boolean isGuestsCanInviteOthers()
	{
		return guestsCanInviteOthers;
	}

	public void setGuestsCanInviteOthers(boolean guestsCanInviteOthers)
	{
		this.guestsCanInviteOthers = guestsCanInviteOthers;
	}

	public boolean isGuestsCanSeeOtherGuests()
	{
		return guestsCanSeeOtherGuests;
	}

	public void setGuestsCanSeeOtherGuests(boolean guestsCanSeeOtherGuests)
	{
		this.guestsCanSeeOtherGuests = guestsCanSeeOtherGuests;
	}

	public boolean isPrivateCopy()
	{
		return privateCopy;
	}

	public void setPrivateCopy(boolean privateCopy)
	{
		this.privateCopy = privateCopy;
	}

	public GoogleEventReminders getReminders()
	{
		return reminders;
	}

	public void setReminders(GoogleEventReminders reminders)
	{
		this.reminders = reminders;
	}

	public boolean isEndTimeUnspecified()
	{
		return endTimeUnspecified;
	}

	public void setEndTimeUnspecified(boolean endTimeUnspecified)
	{
		this.endTimeUnspecified = endTimeUnspecified;
	}

	public boolean isLocked()
	{
		return locked;
	}

	public void setLocked(boolean locked)
	{
		this.locked = locked;
	}

	public String getHangoutLink()
	{
		return hangoutLink;
	}

	public void setHangoutLink(String hangoutLink)
	{
		this.hangoutLink = hangoutLink;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (anyoneCanAddSelf ? 1231 : 1237);
		result = prime * result
				+ ((attendees == null) ? 0 : attendees.hashCode());
		result = prime * result + (attendeesOmitted ? 1231 : 1237);
		result = prime * result + ((colorId == null) ? 0 : colorId.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + (endTimeUnspecified ? 1231 : 1237);
		result = prime * result + ((etag == null) ? 0 : etag.hashCode());
		result = prime * result + ((gadget == null) ? 0 : gadget.hashCode());
		result = prime * result + (guestsCanInviteOthers ? 1231 : 1237);
		result = prime * result + (guestsCanSeeOtherGuests ? 1231 : 1237);
		result = prime * result
				+ ((hangoutLink == null) ? 0 : hangoutLink.hashCode());
		result = prime * result
				+ ((htmlLink == null) ? 0 : htmlLink.hashCode());
		result = prime * result + ((iCalUID == null) ? 0 : iCalUID.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((kind == null) ? 0 : kind.hashCode());
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result + (locked ? 1231 : 1237);
		result = prime * result
				+ ((origanizer == null) ? 0 : origanizer.hashCode());
		result = prime
				* result
				+ ((originalStartTime == null) ? 0 : originalStartTime
						.hashCode());
		result = prime * result + (privateCopy ? 1231 : 1237);
		result = prime * result
				+ ((recurrence == null) ? 0 : recurrence.hashCode());
		result = prime
				* result
				+ ((recurringEventId == null) ? 0 : recurringEventId.hashCode());
		result = prime * result
				+ ((reminders == null) ? 0 : reminders.hashCode());
		result = prime * result + sequence;
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		result = prime * result
				+ ((transparency == null) ? 0 : transparency.hashCode());
		result = prime * result + ((updated == null) ? 0 : updated.hashCode());
		result = prime * result
				+ ((visibility == null) ? 0 : visibility.hashCode());
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
		GoogleEvent other = (GoogleEvent) obj;
		if (anyoneCanAddSelf != other.anyoneCanAddSelf)
			return false;
		if (attendees == null)
		{
			if (other.attendees != null)
				return false;
		} else if (!attendees.equals(other.attendees))
			return false;
		if (attendeesOmitted != other.attendeesOmitted)
			return false;
		if (colorId == null)
		{
			if (other.colorId != null)
				return false;
		} else if (!colorId.equals(other.colorId))
			return false;
		if (created == null)
		{
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (creator == null)
		{
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (description == null)
		{
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (end == null)
		{
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (endTimeUnspecified != other.endTimeUnspecified)
			return false;
		if (etag == null)
		{
			if (other.etag != null)
				return false;
		} else if (!etag.equals(other.etag))
			return false;
		if (gadget == null)
		{
			if (other.gadget != null)
				return false;
		} else if (!gadget.equals(other.gadget))
			return false;
		if (guestsCanInviteOthers != other.guestsCanInviteOthers)
			return false;
		if (guestsCanSeeOtherGuests != other.guestsCanSeeOtherGuests)
			return false;
		if (hangoutLink == null)
		{
			if (other.hangoutLink != null)
				return false;
		} else if (!hangoutLink.equals(other.hangoutLink))
			return false;
		if (htmlLink == null)
		{
			if (other.htmlLink != null)
				return false;
		} else if (!htmlLink.equals(other.htmlLink))
			return false;
		if (iCalUID == null)
		{
			if (other.iCalUID != null)
				return false;
		} else if (!iCalUID.equals(other.iCalUID))
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
		if (location == null)
		{
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (locked != other.locked)
			return false;
		if (origanizer == null)
		{
			if (other.origanizer != null)
				return false;
		} else if (!origanizer.equals(other.origanizer))
			return false;
		if (originalStartTime == null)
		{
			if (other.originalStartTime != null)
				return false;
		} else if (!originalStartTime.equals(other.originalStartTime))
			return false;
		if (privateCopy != other.privateCopy)
			return false;
		if (recurrence == null)
		{
			if (other.recurrence != null)
				return false;
		} else if (!recurrence.equals(other.recurrence))
			return false;
		if (recurringEventId == null)
		{
			if (other.recurringEventId != null)
				return false;
		} else if (!recurringEventId.equals(other.recurringEventId))
			return false;
		if (reminders == null)
		{
			if (other.reminders != null)
				return false;
		} else if (!reminders.equals(other.reminders))
			return false;
		if (sequence != other.sequence)
			return false;
		if (start == null)
		{
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		if (summary == null)
		{
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		if (transparency == null)
		{
			if (other.transparency != null)
				return false;
		} else if (!transparency.equals(other.transparency))
			return false;
		if (updated == null)
		{
			if (other.updated != null)
				return false;
		} else if (!updated.equals(other.updated))
			return false;
		if (visibility == null)
		{
			if (other.visibility != null)
				return false;
		} else if (!visibility.equals(other.visibility))
			return false;
		return true;
	}	
}
