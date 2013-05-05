package resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import models.GoogleEvent;
import security.UAuth;
import security.User;
import clients.GoogleClient;
import daos.GoogleAccessTokenDAO;

@Path("/events")
public class EventsResource
{
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
		return null;
	}
}
