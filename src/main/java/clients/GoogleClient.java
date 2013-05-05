package clients;

import java.net.URI;
import java.util.Set;

import models.GoogleAccessToken;
import models.GoogleEvent;
import models.GoogleEvents;

import com.google.api.services.calendar.model.CalendarList;

public interface GoogleClient
{
	Set<String> getEmails(String token);
	
	GoogleAccessToken getAccessToken(final String code, final URI redirectUri);
	
	CalendarList listCalendars();

	GoogleEvents listCalEvents(String calID);

	GoogleEvent updateCalEvent(String calID, GoogleEvent event);

	GoogleEvent getCalEvent(String calID, String eventID);

}
