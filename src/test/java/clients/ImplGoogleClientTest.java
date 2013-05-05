package clients;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;

public class ImplGoogleClientTest {
	ImplGoogleClient client;
	@Before
	public void setup(){
		 client = new ImplGoogleClient();
	}
@Test
public void test(){
//client.getCalEvent(calID, eventID)
Event tes = client.getCalEvent("82bumu40l9tvmsnujq3kpelhp8@group.calendar.google.com","q15rpnkd6c7i8alrsq2uprs2lg");
try {
	System.out.println(tes.toPrettyString());
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

}

}
