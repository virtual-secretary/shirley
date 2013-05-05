package clients;


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
//		String resp = resource.get(String.class);
//		CalendarList calList;
//		try {
//			calList = fromJson(resp, CalendarList.class);
//			return calList;
//
//		} catch (IOException e) {
//			return null;
//		}
		CalendarList calList = resource.get(CalendarList.class);
		return calList;

	}

	@Override
	public Events listCalEvents(String calID) {
		// get
		// https://www.googleapis.com/calendar/v3/calendars/calendarId/events
		WebResource resource = client
				.resource("https://www.googleapis.com/calendar/v3/calendars/"
						+ calID + "/events");
		Events resp = resource.get(Events.class);
		return resp;
	}

	@Override
	public Event updateCalEvent(String calID,Event event) {
		// PUT https://www.googleapis.com/calendar/v3/calendars/calendarId/events/eventId
		WebResource resource = client
				.resource("https://www.googleapis.com/calendar/v3/calendars/"
						+ calID + "/events/"+event.getId());
		Event resp = resource.put(Event.class, event);
		return resp;
	}

	@Override
	public Event getCalEvent(String calID, String eventID) {
		//GET 
		//https://www.googleapis.com/calendar/v3/calendars/calendarId/events/eventId
		WebResource resource = client.resource("https://www.googleapis.com/calendar/v3/calendars/" + calID "/events/" + eventID);
	
		Event resp = resource.get(Event.class);
		return resp;		

	}

}
