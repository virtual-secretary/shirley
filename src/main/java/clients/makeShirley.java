package clients;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import models.GoogleEvent;
import models.GoogleEventAttendee;
import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
import com.google.code.linkedinapi.client.enumeration.SearchParameter;
import com.google.code.linkedinapi.schema.People;
import com.shirley.client.linkedin.Person;

//consumes google List<events> makes List<ShirleyEvents>
public class makeShirley {
	public makeShirley(){
		
	}
	public doEvents(){
		
	}
	public String readEventForLinkedin(GoogleEvent event){
		List<GoogleEventAttendee> attendees = event.getAttendees();
		for(GoogleEventAttendee attendee:attendees){
			
			Map<SearchParameter, String> searchParameters = new EnumMap<SearchParameter, String>(SearchParameter.class);
			searchParameters.put(SearchParameter.KEYWORDS, attendee.getDisplayName());
			//LinkedInApiClientFactory.newInstance(consumerKey, consumerSecret)
			LinkedInApiClient linkedIn = LinkedInApiClientFactory.newInstance(consumerKey, consumerSecret);
			People people = client.searchPeople(searchParameters);
			System.out.println("Total search result:" + people.getCount());
			for (com.google.code.linkedinapi.schema.Person person : people.getPersonList()) {
			        System.out.println(person.getId() + ":" + person.getFirstName() + " " + person.getLastName() + ":" + person.getHeadline());
			}		}

	}
	public List<User> readEventForTwitter(GoogleEvent event){
		ArrayList<User> twitterAttendees = new ArrayList<User>();
		List<GoogleEventAttendee> attendees = event.getAttendees();
		for(GoogleEventAttendee attendee:attendees){
			Twitter twitter =TwitterFactory.getSingleton();
			ResponseList<User> list;
			try {
				list = twitter.searchUsers(attendee.getDisplayName(), 1);
				if (list.size()>0){
					twitterAttendees.add(list.get(0));
				}
			} catch (TwitterException e) {
				e.printStackTrace();
			}

		}
		return twitterAttendees;
	}
}
