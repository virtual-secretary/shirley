package clients;

import static com.yammer.dropwizard.testing.JsonHelpers.asJson;

import java.util.Date;

import models.GoogleEvents;

import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.UniformInterfaceException;

public class GoogleClientImplTest
{
	GoogleClientImpl client;

	@Before
	public void setup()
	{
		client = new GoogleClientImpl();
	}

	@Test
	public void test() throws Exception
	{
		// client.getCalEvent(calID, eventID)
		client.setAccessToken("ya29.AHES6ZS765vFoO7h-1nAycV6XuCk57wwq01CVchtMGqAzaze7lNkRw");
		try
		{
			System.out.println(asJson(client.getCalendars()));
			GoogleEvents res = client.getEvents("myung.sun.rex@gmail.com", 2, new Date());
			System.out.println(asJson(res));
		} catch ( UniformInterfaceException e)
		{
			System.out.println(e.getResponse().getEntity(String.class));
		}
		

	}

}
