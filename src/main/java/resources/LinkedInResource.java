package resources;

import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import models.UserSettings;
import security.UAuth;
import security.User;

import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthService;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthServiceFactory;
import com.google.code.linkedinapi.client.oauth.LinkedInRequestToken;
import com.mongodb.DB;

@Path("oauth/linkedin")
public class LinkedInResource
{
	private final static String API_KEY = "veffajn4yiim";
	private final static String SECRET_KEY = "7HnDNngrRzMmiCbF";
	private final static String USER_TOKEN = "93bc2947-8b36-4ff0-b7a5-f02a24f0c0a0";
	private final static String USER_SECRET = "f2b532f6-908e-4f1f-b89e-ee4a1d4db20c";
	
	private DB db;
	
	@Path("connect")
	public Response connect(
			@UAuth User user,
			@QueryParam("code") String code) throws Exception
	{
		final LinkedInOAuthService oauthService = LinkedInOAuthServiceFactory.getInstance().createLinkedInOAuthService(API_KEY, SECRET_KEY);
		LinkedInRequestToken requestToken = oauthService.getOAuthRequestToken();
		LinkedInAccessToken oAuthAccessToken = oauthService.getOAuthAccessToken(requestToken, code);
		UserSettings setting = user.getSetting();
		setting.setLinkedin(true);
		
		// TODO:: Save the oAuthAccessToken
		
		return Response.ok().build();
	}

}
