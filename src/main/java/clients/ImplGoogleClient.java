package clients;

import static com.yammer.dropwizard.testing.JsonHelpers.fromJson;
import models.EventsOptionsModel;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.Calendar.CalendarList.List;
import com.google.api.services.calendar.model.*;
import com.sun.jersey.api.client.WebResource;


public class ImplGoogleClient implements GoogleClient{
	private final Client client;

	@Override
	public CalendarList listCalendars() {
		//GET https://www.googleapis.com/calendar/v3/users/me/calendarList

		WebResource resource = client.resource("https://www.googleapis.com/calendar/v3/users/me/calendarList");
		//CalendarService service new CalendarService();
		//resource.
		String resp = resource.get(String.class);
		CalendarList calList=fromJson(resp, CalendarList.class);
		return calList;
		
	}

	@Override
	public List listCalEvents(String calID) {
		//get https://www.googleapis.com/calendar/v3/calendars/calendarId/events
		WebResource resource = client.resource("https://www.googleapis.com/calendar/v3/calendars/"+calID+"/events");
		String resp = resource.get(String.class);
		List list = fromJson(resp,List.class); 
		//list.get
		return null;
	}

	@Override
	public boolean updateCalEvent(Event event, EventsOptionsModel options) {
		// PUT https://www.googleapis.com/calendar/v3/calendars/calendarId/events/eventId
		return false;
	}

	@Override
	public Event getCalEvent(String calID, String eventID) {
		//GET https://www.googleapis.com/calendar/v3/calendars/calendarId
		return null;
	}

}
