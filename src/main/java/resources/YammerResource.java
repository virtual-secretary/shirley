package resources;

import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import models.LinkedInAccessTokenDAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import security.UAuth;
import security.User;
import daos.LinkedInRequestTokenDAO;
import daos.UserDAO;

@Path("/oauth/yammer")
public class YammerResource
{
	public static String reqToken;
	
	private final static Logger LOG = LoggerFactory.getLogger(YammerResource.class);
	
	private static final String CLIENT_KEY = "IDy1kcPFW8toHARsOdMZQ";
	private static final String CLIENT_SECRET = "8oAqqwIbdU6VEKXF56J3qnhLYbnlHRmIKqVYw7NiE";
	
	private URI serverURI;
	private UserDAO userDAO;
	private LinkedInRequestTokenDAO reqDAO;
	private LinkedInAccessTokenDAO accDAO;
	
	private URI getAbsoluteResourceURI()
	{
		return UriBuilder.fromUri(
							serverURI.getScheme() + "://" + serverURI.getHost()
							).path("api").path( 
							UriBuilder.fromResource(YammerResource.class).build().toString()
						  )
						 .build();
	}
	
	@GET
	@Path("auth")
	public Response auth(@UAuth User user, 
			@QueryParam("method") String method) throws Exception
	{
		String userId = user.getId();

		URI redirectURL = UriBuilder.fromUri(getAbsoluteResourceURI())
									.path(method).build();
		
		URI authURL = UriBuilder.fromUri("https://www.yammer.com/dialog/oauth")
								.queryParam("client_id", CLIENT_KEY)
								.queryParam("redirect_uri", redirectURL.toString()).build();
		
		return Response.seeOther(authURL).build();
	}
	
	@GET
	@Path("connect")
	public Response connect(
			@UAuth User user,
			@QueryParam("code") String code) throws Exception
	{
//		UriBuilder.fromUri("https://www.yammer.com/oauth2")
//					.
//					.queryParam("", values)
		
		return Response.ok().build();
	}
}
