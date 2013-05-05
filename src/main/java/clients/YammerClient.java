package clients;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class YammerClient
{
	private static final String CLIENT_KEY = "IDy1kcPFW8toHARsOdMZQ";
	private static final String CLIENT_SECRET = "8oAqqwIbdU6VEKXF56J3qnhLYbnlHRmIKqVYw7NiE";
	private Client client;
	
	public YammerClient(Client client)
	{
		this.client = client;
	}
	
	public String getUserProfile(String email)
	{
		WebResource resource = client.resource("https://www.yammer.com/");
		return resource.path("api/v1/users/by_email.json")
						.queryParam("email", "user@domain.com")
						.get(String.class); 
	}
}
