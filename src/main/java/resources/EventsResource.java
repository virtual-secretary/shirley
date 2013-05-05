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

import com.google.api.services.calendar.model.Event;

import daos.EventsDAO;

import models.ShirleyEvent;
@Path("/events")
public class EventsResource
{
	private final static long tenDays = 864000000;
	private final EventsDAO eventsDAO;
	public EventsResource(EventsDAO eventsDAO){
		super();
		this.eventsDAO = eventsDAO;

	}
	@GET
	public List<Event> getEvents (@QueryParam("from") String from,@QueryParam("to") String to) throws Exception
	{
		Date fromDate = getDateFromString(from);
		Date endDate = getDateFromString(to);
		List<Event> events = new ArrayList<Event>();;
		if(fromDate.before(endDate)){
			//clamps to the date range to <10
			if(fromDate.getTime()-endDate.getTime()<tenDays){
				endDate = new Date(fromDate.getTime()+tenDays);
			}
			events.addAll(eventsDAO.getEventsForDateRange(fromDate,endDate).get());
			return events;
		}
		return getEvents(from);
	}
	@GET
	public List<Event> getEvents (@QueryParam("from") String from) throws Exception
	{
		Date fromDate = getDateFromString(from);
		return eventsDAO.getEventsForDay(fromDate).get();

	}
	@GET
	public List<Event> getEvents () throws Exception
	{
		//today
		return eventsDAO.getEventsForDay(new Date()).get();

	}
	private Date getDateFromString(String dateString) {
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date date = df.parse(dateString);
			return date;
		} catch (ParseException e) {
			//WebApplicationException ...("Date format should be yyyy-MM-dd'T'HH:mm:ss", Status.BAD_REQUEST);
			return new Date();
		}
	}
}
