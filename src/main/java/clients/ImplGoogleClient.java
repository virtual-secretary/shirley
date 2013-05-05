package clients;

import static com.yammer.dropwizard.testing.JsonHelpers.fromJson;

import java.io.IOException;

import models.EventsOptionsModel;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.Calendar.CalendarList.List;
import com.google.api.services.calendar.model.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;


public class ImplGoogleClient implements GoogleClient{
	private final Client client;
	public ImplGoogleClient(){
		this.client = new Client();
	}
	@Override
	public CalendarList listCalendars() {
		//GET https://www.googleapis.com/calendar/v3/users/me/calendarList

		WebResource resource = client.resource("https://www.googleapis.com/calendar/v3/users/me/calendarList");
		//CalendarService service new CalendarService();
		//resource.
		String resp = resource.get(String.class);
		CalendarList calList;
		try {
			calList = fromJson(resp, CalendarList.class);
			return calList;

		} catch (IOException e) {
			return null;
		}

	}

	@Override
	public Events listCalEvents(String calID) {
		// get
		// https://www.googleapis.com/calendar/v3/calendars/calendarId/events
		WebResource resource = client
				.resource("https://www.googleapis.com/calendar/v3/calendars/"
						+ calID + "/events");
		String resp = resource.get(String.class);
		try {
			Events events = fromJson(resp, Events.class);
			return events;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}
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
