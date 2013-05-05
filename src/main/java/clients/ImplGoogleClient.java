package clients;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.MediaType;

import models.GoogleAccessToken;
import models.GoogleEvent;
import models.GoogleEvents;
import models.GoogleUserInfoResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.api.services.calendar.model.CalendarList;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;

public class ImplGoogleClient implements GoogleClient
{
	private final static Logger LOG = LoggerFactory.getLogger(ImplGoogleClient.class);
	
	private final static String CLIENT_ID = "817343750420-5bq1gtg8ttba0io5dcp86iv9leu4lq09.apps.googleusercontent.com";
	private final static String CLIENT_SECRET = "gw1jYjyAi_CnQ9Ivxi9wKrtL";
	private final String APIKEY = "AIzaSyAWjk-ee7cHY64_CzpfwX0VtvHLfCC93j8";
	private final Client client;

	public ImplGoogleClient()
	{
		this.client = new Client();
	}

	@Override
	public CalendarList listCalendars()
	{
		// GET https://www.googleapis.com/calendar/v3/users/me/calendarList

		WebResource resource = client.resource(
				"https://www.googleapis.com/calendar/v3/users/me/calendarList")
				.queryParam("key", APIKEY);
		// CalendarService service new CalendarService();
		// resource.
		// String resp = resource.get(String.class);
		// CalendarList calList;
		// try {
		// calList = fromJson(resp, CalendarList.class);
		// return calList;
		//
		// } catch (IOException e) {
		// return null;
		// }
		CalendarList calList = resource.get(CalendarList.class);
		return calList;

	}

	@Override
	public GoogleEvents listCalEvents(String calID)
	{
		// get
		// https://www.googleapis.com/calendar/v3/calendars/calendarId/events
		WebResource resource = client.resource(
				"https://www.googleapis.com/calendar/v3/calendars/" + calID
						+ "/events").queryParam("key", APIKEY);
		GoogleEvents resp = resource.get(GoogleEvents.class);
		return resp;
	}

	@Override
	public GoogleEvent updateCalEvent(String calID, GoogleEvent event)
	{
		// PUT
		// https://www.googleapis.com/calendar/v3/calendars/calendarId/events/eventId
		WebResource resource = client.resource(
				"https://www.googleapis.com/calendar/v3/calendars/" + calID
						+ "/events/" + event.getId()).queryParam("key", APIKEY);
		
		return resource.put(GoogleEvent.class, event);
	}

	@Override
	public GoogleEvent getCalEvent(String calID, String eventID)
	{
		// GET
		// https://www.googleapis.com/calendar/v3/calendars/calendarId/events/eventId
		WebResource resource = client.resource(
				"https://www.googleapis.com/calendar/v3/calendars/" + calID
						+ "/events/" + eventID).queryParam("key", APIKEY);
		// Event resp = resource.get(Event.class);
		GoogleEvent googleEvent = resource.get(GoogleEvent.class);
		return googleEvent;
	}

	@Override
	public Set<String> getEmails(String token)
	{
		WebResource resource = client.resource("https://www.googleapis.com");
		HashSet<String> hashSet = new HashSet<String>();
		
		try
		{
			GoogleUserInfoResponse response = resource.path("oauth2/v1/userinfo")
														.queryParam("access_token", token)
														.accept(MediaType.APPLICATION_JSON_TYPE)
														.get(GoogleUserInfoResponse.class);

			if ( response.isVerifiedEmail() )
			{
				hashSet.add(response.getEmail()); 
			}
		} 
		catch ( UniformInterfaceException e )
		{
			LOG.warn("\n\tresponse : {}", e.getResponse().getEntity(String.class));
			throw e;
		}
		
		return hashSet;
	}

	@Override
	public GoogleAccessToken
			getAccessToken(String code, URI redirectUri)
	{
		String clientId = CLIENT_ID;
		String clientSecret = CLIENT_SECRET;
		
		GoogleAccessToken response = null;
		WebResource resource = client.resource("https://accounts.google.com");
		Form entity = new Form();
		entity.add("code", code);
		entity.add("client_id", clientId);
		entity.add("client_secret", clientSecret);
		entity.add("redirect_uri", redirectUri);
		entity.add("grant_type", "authorization_code");
		
		try
		{
			response = resource.path("o/oauth2/token")
								.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
								.accept(MediaType.APPLICATION_JSON_TYPE)
								.entity(entity)
								.post(GoogleAccessToken.class);
		} 
		catch ( UniformInterfaceException e )
		{
			LOG.debug("\n\tresponse : {}", e.getResponse().getEntity(String.class));
			throw e;
		}
		
		return response;
	}

}
