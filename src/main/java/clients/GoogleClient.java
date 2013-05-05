package clients;

import com.google.api.services.calendar.model.CalendarList;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;

public interface GoogleClient
{

	CalendarList listCalendars();

	Events listCalEvents(String calID);

	Event updateCalEvent(String calID, Event event);

	Event getCalEvent(String calID, String eventID);

}
