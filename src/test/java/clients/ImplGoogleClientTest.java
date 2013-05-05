package clients;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

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
Events tes = client.listCalEvents("82bumu40l9tvmsnujq3kpelhp8@group.calendar.google.com");
try {
	System.out.println(tes.toPrettyString());
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

}

}
