package resources;

import java.net.URI;
import java.util.EnumMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import models.LinkedInAccessTokenDAO;
import models.UserSettings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import security.UAuth;
import security.User;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientException;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
import com.google.code.linkedinapi.client.enumeration.SearchParameter;
import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthService;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthServiceFactory;
import com.google.code.linkedinapi.client.oauth.LinkedInRequestToken;
import com.google.code.linkedinapi.schema.People;

import daos.LinkedInRequestTokenDAO;
import daos.UserDAO;

@Path("/oauth/linkedin")
public class LinkedInResource
{
	private final static Logger LOG = LoggerFactory.getLogger(LinkedInResource.class);
	
	private final static String API_KEY = "veffajn4yiim";
	private final static String SECRET_KEY = "7HnDNngrRzMmiCbF";
	private final static String USER_TOKEN = "93bc2947-8b36-4ff0-b7a5-f02a24f0c0a0";
	private final static String USER_SECRET = "f2b532f6-908e-4f1f-b89e-ee4a1d4db20c";
	
	private URI serverURI;
	private UserDAO userDAO;
	private LinkedInRequestTokenDAO reqDAO;
	private LinkedInAccessTokenDAO accDAO;
	
	private URI getAbsoluteResourceURI()
	{
		return UriBuilder.fromUri(
							serverURI.getScheme() + "://" + serverURI.getHost()
							).path("api").path( 
							UriBuilder.fromResource(LinkedInResource.class).build().toString()
						  )
						 .build();
	}
	
	public LinkedInResource(URI serverURI, UserDAO userDAO,
			LinkedInRequestTokenDAO reqDAO, LinkedInAccessTokenDAO accDAO)
	{
		super();
		this.serverURI = serverURI;
		this.userDAO = userDAO;
		this.reqDAO = reqDAO;
		this.accDAO = accDAO;
	}



	@GET
	@Path("auth")
	public Response auth(@UAuth User user, 
			@QueryParam("method") String method) throws Exception
	{
		String userId = user.getId();

		URI redirectURL = UriBuilder.fromUri(getAbsoluteResourceURI())
				.path(method).build();
		final LinkedInOAuthService oauthService = LinkedInOAuthServiceFactory
				.getInstance().createLinkedInOAuthService(API_KEY, SECRET_KEY);
		
		LinkedInRequestToken reqToken = reqDAO.getRequestTokenByDeveloper(userId);
		
		if ( reqToken == null )
		{
			reqToken = oauthService.getOAuthRequestToken(redirectURL.toString());
			LOG.debug("\n\tAuth token not found, requesting {}", reqToken);
			reqDAO.save(userId, reqToken);
		}
		
		URI authURL = UriBuilder.fromUri(reqToken.getAuthorizationUrl()).queryParam("scope", "r_fullprofile r_network r_emailaddress").build();
		
		return Response.seeOther(authURL).build();
	}
	
	@GET
	@Path("connect")
	public Response connect(
			@UAuth User user,
			@QueryParam("oauth_token") String token,
			@QueryParam("oauth_verifier") String code) throws Exception
	{
		final LinkedInOAuthService oauthService = LinkedInOAuthServiceFactory.getInstance().createLinkedInOAuthService(API_KEY, SECRET_KEY);
		
		LinkedInRequestToken requestToken = reqDAO.getRequestTokenByDeveloper(user.getId());
		
		if ( requestToken == null )
		{
			// REQUEST TOKEN
			requestToken = oauthService.getOAuthRequestToken();
			LOG.debug("TOKEN requested {} ", requestToken.getToken());
		}
		
		
		LinkedInAccessToken oAuthAccessToken = oauthService.getOAuthAccessToken(requestToken, code);
		
		UserSettings setting = user.getSetting();
		
		setting.setLinkedin(true);
		userDAO.updateSetting(user);
		accDAO.save(user.getId(), oAuthAccessToken);
		
		return Response.ok().build();
	}
	
	@GET
	@Path("profile")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getProfile(
			@UAuth User user, 
			@QueryParam("first") String first,
			@QueryParam("last") String last,
			@QueryParam("company") String company) throws Exception
	{
		UserSettings setting = user.getSetting();
		if ( !setting.isLinkedin() )
		{
			// TODO :: warn client that this user needs to be connect to google or maybe redirect
		}
		
		LinkedInAccessToken accToken = accDAO.getRequestTokenByDeveloper(user.getId());
		
		if ( accToken == null )
		{
			// TODO :: warn client that this user needs to be connect to google or maybe redirect
		}
		
		final LinkedInApiClientFactory factory = LinkedInApiClientFactory.newInstance("veffajn4yiim", "7HnDNngrRzMmiCbF");
		LinkedInApiClient client = factory.createLinkedInApiClient(accToken);
		
		Map<SearchParameter, String> searchParameters = new EnumMap<SearchParameter, String>(SearchParameter.class);
		
		if ( first != null )
			searchParameters.put(SearchParameter.FIRST_NAME, first);
		if ( last != null )
			searchParameters.put(SearchParameter.LAST_NAME, last);
		if ( company != null )
			searchParameters.put(SearchParameter.COMPANY_NAME, last);
		
		try
		{
			People users = client.searchPeople(searchParameters);
			return users;
		}
		catch ( LinkedInApiClientException e )
		{
			LOG.error("Exception", e);
		}
		
		return null;
		
	}

}
