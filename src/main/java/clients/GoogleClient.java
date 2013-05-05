package clients;

import java.net.URI;
import java.util.Date;
import java.util.Set;

import models.GoogleAccessToken;
import models.GoogleCalendarList;
import models.GoogleEvent;
import models.GoogleEvents;

public interface GoogleClient
{
	void setAccessToken(String token);
	
	Set<String> getEmails(String token);
	
	GoogleAccessToken getAccessToken(final String code, final URI redirectUri);
	
	GoogleCalendarList getCalendars();

	GoogleEvents getEvents(String calID, int page, Date date);

	GoogleEvent updateCalEvent(String calID, GoogleEvent event);

	GoogleEvent getEvent(String calID, String eventID);

}
