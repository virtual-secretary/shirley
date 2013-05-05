package resources;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import models.GoogleAccessToken;
import models.GoogleCalendarEntity;
import models.GoogleCalendarList;
import models.GoogleEvent;
import models.GoogleEvents;
import models.UserSettings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.api.client.UniformInterfaceException;

import security.UAuth;
import security.User;
import clients.GoogleClient;
import daos.GoogleAccessTokenDAO;

@Path("/events")
public class EventsResource
{
	private final static Logger LOG = LoggerFactory.getLogger(EventsResource.class);
	
	private GoogleClient googleClient;
	private GoogleAccessTokenDAO gatDAO;
	
	public EventsResource(GoogleClient googleClient, GoogleAccessTokenDAO gatDAO)
	{
		super();
		this.googleClient = googleClient;
		this.gatDAO = gatDAO;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<GoogleEvent> getEvents(
			@UAuth User user) throws Exception
	{
		UserSettings setting = user.getSetting();
		if ( !setting.isGoogle())
		{
			// TODO :: warn client that this user needs to be connect to google or maybe redirect
		}
		
		GoogleAccessToken accToken = gatDAO.findByUser(user.getId());
		
		if ( accToken == null )
		{
			// TODO :: warn client that this user needs to be connect to google or maybe redirect
		}
		
		googleClient.setAccessToken(accToken.getAccessToken());
		GoogleCalendarList calendars = googleClient.getCalendars();
		List<GoogleCalendarEntity> items = calendars.getItems();
		
		final Date now = new Date();
		List<GoogleEvent> events = new ArrayList<GoogleEvent>();
		
		
		for (GoogleCalendarEntity entity : items)
		{
			String id = entity.getId();
			if (id != null)
			{
				try
				{
					GoogleEvents googleEvents = googleClient.getEvents(id, 0,
							now);
					List<GoogleEvent> items2 = googleEvents.getItems();
					for (GoogleEvent event : items2)
					{
						events.add(event);
					}
				} catch (UniformInterfaceException e)
				{
					LOG.error("e: {}", e.getResponse().getEntity(String.class));
				}

			}
		}
		
		
		return events;
	}
}
