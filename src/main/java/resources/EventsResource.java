package resources;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import security.UAuth;
import security.User;

import clients.GoogleClient;

import com.google.api.services.calendar.model.CalendarList;
import com.google.api.services.calendar.model.CalendarListEntry;
import com.google.api.services.calendar.model.Event;
import com.yammer.dropwizard.jersey.params.IntParam;

import daos.EventsDAO;

@Path("/events")
public class EventsResource
{
	private final static long tenDays = 864000000;
	private final EventsDAO eventsDAO;
	private GoogleClient googleClient;
	
	public EventsResource(EventsDAO eventsDAO)
	{
		super();
		this.eventsDAO = eventsDAO;
	}

	@GET
	public List<Event> getEvents(
			@UAuth User user,
			@QueryParam("from") String from,
			@QueryParam("page") IntParam page) throws Exception
	{
		Date fromDate = getDateFromString(from);
		CalendarList listCalendars = googleClient.getCalendars();
		List<CalendarListEntry> items = listCalendars.getItems();
		items.get(0).getId();
		
		List<Event> events = new ArrayList<Event>();
		
		
		return getEvents(from);
	}

	@GET
	public List<Event> getEvents(@QueryParam("from") String from)
			throws Exception
	{
		Date fromDate = getDateFromString(from);
		return eventsDAO.getEventsForDay(fromDate).get();

	}

	@GET
	public List<Event> getEvents() throws Exception
	{
		// today
		return eventsDAO.getEventsForDay(new Date()).get();

	}

	private Date getDateFromString(String dateString)
	{
		try
		{
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date date = df.parse(dateString);
			return date;
		} 
		catch (ParseException e)
		{
			// WebApplicationException
			// ...("Date format should be yyyy-MM-dd'T'HH:mm:ss",
			// Status.BAD_REQUEST);
			return new Date();
		}
	}
}
