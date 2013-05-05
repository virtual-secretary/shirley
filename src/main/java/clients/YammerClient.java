package clients;

import models.YamerAccessTokenResponse;
import models.YammerAccessToken;

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
	
	public YammerAccessToken getAccessToken(String code)
	{
		WebResource r = client.resource("https://www.yammer.com/oauth2");
				
		YamerAccessTokenResponse string = r.path("access_token.json")
						.queryParam("client_id", CLIENT_KEY)
						.queryParam("client_secret", CLIENT_SECRET)
						.queryParam("code", code)
						.get(YamerAccessTokenResponse.class);
		return string.getAccessToken();
	}
	
	
	public String getUserProfile(String token, String email)
	{
		WebResource resource = client.resource("https://www.yammer.com/");
		
		return resource.path("api/v1/users/by_email.json")
						.queryParam("access_token", token)
						.queryParam("email", email)
						.get(String.class); 
	}
	
	
	
	
}
