package resources;

import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import models.GoogleAccessToken;
import models.UserSettings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import security.UAuth;
import security.User;
import clients.GoogleClient;
import daos.GoogleAccessTokenDAO;
import daos.UserDAO;

@Path("oauth/google")
public class GoogleOAuthResource
{
	private final static String CLIENT_ID = "817343750420-5bq1gtg8ttba0io5dcp86iv9leu4lq09.apps.googleusercontent.com";
	private final static Logger LOG = LoggerFactory.getLogger(GoogleOAuthResource.class);
	
	private URI serverURI;
	private GoogleClient client;
	private GoogleAccessTokenDAO tokenDAO;
	private UserDAO userDAO;
	
	private URI getAbsoluteResourceURI()
	{
		return UriBuilder.fromUri(
							serverURI.getScheme() + "://" + serverURI.getHost()
							).path(
							UriBuilder.fromResource(GoogleOAuthResource.class).build().toString()
						  )
						 .build();
	}
	
	public GoogleOAuthResource(URI serverURI, GoogleClient client,
			GoogleAccessTokenDAO tokenDAO, UserDAO userDAO)
	{
		super();
		this.serverURI = serverURI;
		this.client = client;
		this.tokenDAO = tokenDAO;
		this.userDAO = userDAO;
	}

	@GET
	@Path("auth")
	public Response auth(@UAuth User user, 
						@QueryParam("method") String method) throws Exception
	{
		URI redirectURL = UriBuilder.fromUri(getAbsoluteResourceURI()).path("method").build();
		URI authURL = UriBuilder.fromUri("https://accounts.google.com/o/oauth2/auth?response_type=code")
								.queryParam("client_id", CLIENT_ID)
								.queryParam("scope", "https://www.googleapis.com/auth/calendar+https://www.googleapis.com/auth/userinfo.email+https://www.googleapis.com/auth/userinfo.profile")
								.queryParam("redirect_uri", redirectURL.toString())
								.build();
								  
		return Response.seeOther(authURL).build();
	}
	
	@GET
	@Path("connect")
	public Response connectWithGithub(
			@UAuth User user,
			@QueryParam("code") String code) throws Exception
	{
		final URI redirectURI = UriBuilder.fromUri(getAbsoluteResourceURI()).path("connect").build();
		GoogleAccessToken accessToken = client.getAccessToken(code, redirectURI);
		
		tokenDAO.save(accessToken);
		UserSettings setting = user.getSetting();
		setting.setGoogle(true);
		userDAO.updateSetting(user);
		return Response.ok().build();
	}
}
