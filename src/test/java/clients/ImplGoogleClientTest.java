package clients;

import static com.yammer.dropwizard.testing.JsonHelpers.asJson;
import models.GoogleEvent;

import org.junit.Before;
import org.junit.Test;

import com.google.api.services.calendar.model.CalendarList;

public class ImplGoogleClientTest
{
	ImplGoogleClient client;

	@Before
	public void setup()
	{
		client = new ImplGoogleClient();
	}

	@Test
	public void test() throws Exception
	{
		// client.getCalEvent(calID, eventID)
		GoogleEvent res = client.getCalEvent(
				"82bumu40l9tvmsnujq3kpelhp8@group.calendar.google.com",
				"q15rpnkd6c7i8alrsq2uprs2lg");
		
		System.out.println(asJson(res));
		
		CalendarList listCalendars = client.listCalendars();
		
		System.out.println(asJson(listCalendars));
	}

}
