package resources;

import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import security.UAuth;
import security.User;
import twitter4j.Twitter;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import daos.TwitterAccessTokenDAO;
import daos.TwitterRequestTokenDAO;
import daos.UserDAO;

@Path("oauth/twitter")
public class TwitterResource
{
	private URI serverURI;
	private Twitter twitter;
	private UserDAO userDAO;
	private TwitterRequestTokenDAO reqDAO;
	private TwitterAccessTokenDAO accDAO;
	
	private URI getAbsoluteResourceURI()
	{
		return UriBuilder.fromUri(
							serverURI.getScheme() + "://" + serverURI.getHost()
							).path("api").path(
							UriBuilder.fromResource(TwitterResource.class).build().toString()
						  )
						 .build();
	}
	
	public TwitterResource(URI serverURI, Twitter twitter, UserDAO userDAO,
			TwitterRequestTokenDAO reqDAO, TwitterAccessTokenDAO accDAO)
	{
		super();
		this.serverURI = serverURI;
		this.twitter = twitter;
		this.userDAO = userDAO;
		this.reqDAO = reqDAO;
		this.accDAO = accDAO;
	}

	@GET
	@Path("auth")
	public Response auth(@UAuth User user, @QueryParam("method") String method)
			throws Exception
	{
		String userId = user.getId();

		URI redirectURL = UriBuilder.fromUri(getAbsoluteResourceURI())
				.path(method).build();
		RequestToken reqToken = reqDAO.findByUser(userId);
		
		if ( reqToken == null )
		{
			reqToken = twitter.getOAuthRequestToken(redirectURL.toString());
			reqDAO.save(userId, reqToken);
		}
		
		URI authURI = UriBuilder.fromUri(reqToken.getAuthorizationURL()).build();
		
		return Response.seeOther(authURI).build();
	}
	
	@GET
	@Path("connect")
	public Response connect(
			@UAuth User user,
			@QueryParam("oauth_token") String token,
			@QueryParam("oauth_verifier") String code) throws Exception
			
	{
		RequestToken reqToken = reqDAO.findByUser(user.getId());
		if ( !reqToken.getToken().equals(token) )
		{
			new WebApplicationException(Response.Status.UNAUTHORIZED);
		}
		
		AccessToken oAuthAccessToken = twitter.getOAuthAccessToken(reqToken, code);
		
		user.getSetting().setTwiiter(true);
		userDAO.updateSetting(user);
		
		accDAO.save(user.getId(), oAuthAccessToken);
		
		return Response.ok().build();
	}
	
}