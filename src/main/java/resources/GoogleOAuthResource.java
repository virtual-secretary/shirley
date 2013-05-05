package resources;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
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
	private final static Logger LOG = LoggerFactory.getLogger(GoogleOAuthResource.class);
	
	private URI serverURI;
	private GoogleClient client;
	private GoogleAccessTokenDAO tokenDAO;
	private UserDAO userDAO;
	
	private URI getAbsoluteResourceURI()
	{
		return UriBuilder.fromUri(
							serverURI.getScheme() + "://" + serverURI.getHost() + 
//							(serverURI.getPort() == 80 ? "" : serverURI.getPort()) +
							"/api" + UriBuilder.fromResource(GoogleOAuthResource.class).build().toString()
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
	@Path("login")
	public Response loginWithGoogle(
			@Context HttpServletRequest req,
			@QueryParam("code") String code)
	{
		return null;
	}
	
	@GET
	@Path("register")
	public Response registerWithGoogle(
			@Context HttpServletRequest req,
			@QueryParam("code") String code) throws Exception
	{
		return this.loginWithGoogle(req, code); 
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
