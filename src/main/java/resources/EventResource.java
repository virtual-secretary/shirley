package resources;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.api.services.calendar.model.Event;

import daos.EventDAO;

@Path("/event")
public class EventResource
{
	private final EventDAO eventDAO;

	public EventResource(EventDAO eventsDAO)
	{
		super();
		this.eventDAO = eventsDAO;

	}

	@Path("/{EventID}")
	@GET
	public Event getUser(@PathParam("EventID") String eventID)
	{
		return eventDAO.getEvent(eventID).get();
	}

	@Path("/{EventID}")
	@PUT
	public Event updateUser(@PathParam("EventID") String eventID, Event event)
	{
		return eventDAO.updateEvent(eventID, event).get();
	}

}
