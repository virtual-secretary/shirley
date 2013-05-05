package resources;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;

import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import com.shirley.client.linkedin.Person;

import daos.EventDAO;
import daos.TwitterAccessTokenDAO;

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
	public void getUser(@PathParam("EventID") String eventID)
	{		
		ArrayList<User> twitterAttendees = new ArrayList<User>();
		ArrayList<Person> LinkedInAttendees = new ArrayList<Person>();

		Twitter twitter =TwitterFactory.getSingleton();
		TwitterAccessTokenDAO doo;
		AccessToken token = doo.findByUser("");
		twitter.setOAuthAccessToken(token);
		//twitter.searchUsers(Event., page);
		Event eve = eventDAO.getEvent(eventID).get();
		java.util.List<EventAttendee> list = eve.getAttendees();
		ResponseList<User> userList;

		for(EventAttendee attendee:list){
			try {
				userList = twitter.searchUsers(attendee.getDisplayName(), 1);
				if (userList.size()>0){
					twitterAttendees.add(userList.get(0));
				}
			} catch (TwitterException e) {
				e.printStackTrace();
			}
			try {
				userList = linkedIn.searchUsers(attendee.getDisplayName(), 1);
				if (userList.size()>0){
					twitterAttendees.add(userList.get(0));
				}
			} catch (TwitterException e) {
				e.printStackTrace();
			}
			
		}
	}

	@Path("/{EventID}")
	@PUT
	public Event updateUser(@PathParam("EventID") String eventID, Event event)
	{
		return eventDAO.updateEvent(eventID, event).get();
	}

}
