package clients;

import java.net.URI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adcnx.account.configs.MongoDAOFactory;
import com.adcnx.account.responses.GoogleUserInfoResponse;
import com.adcnx.api.helpers.ResourceHelper;
import com.adcnx.auth.OAuth2Store;
import com.adcnx.auth.tokens.GoogleAccessToken;
import com.adcnx.db.dao.oauth.OAuth2StoreDAO;
import com.adcnx.db.daofactory.DAOFactory;
import com.google.common.base.Optional;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

public class JerseyGoogleOAuthClient implements GoogleOAuthClient
{
	private final Logger LOG = LoggerFactory.getLogger(JerseyGoogleOAuthClient.class);
	
	private final Client client;
	private OAuth2StoreDAO authDAO;
	 
	public JerseyGoogleOAuthClient(Client client)
	{
		super();
		this.client = client;
		final DAOFactory daoFactory = DAOFactory.getDAOFactory(MongoDAOFactory.class);
		authDAO = daoFactory.getDAO(OAuth2StoreDAO.class);
	}
	@Override
	public Set<String> getEmails(String token)
	{
		WebResource resource = client.resource("https://www.googleapis.com");
		HashSet<String> hashSet = new HashSet<String>();
		
		try
		{
			GoogleUserInfoResponse response = resource.path("oauth2/v1/userinfo")
														.queryParam("access_token", token)
														.accept(MediaType.APPLICATION_JSON_TYPE)
														.get(GoogleUserInfoResponse.class);

			if ( response.isVerifiedEmail() )
			{
				hashSet.add(response.getEmail()); 
			}
		} 
		catch ( UniformInterfaceException e )
		{
			LOG.debug("\n\tresponse : {}", e.getResponse().getEntity(String.class));
			throw e;
		}
		
		return hashSet;
	}

	@Override
	public GoogleAccessToken
			getAccessToken(String code, URI redirectUri)
	{
		Optional<OAuth2Store> google = authDAO.findOneWithName("google");
		ResourceHelper.serverErrorIfNotPresent(google);
		
		OAuth2Store store = google.get();
		String clientId = store.getClientId();
		String clientSecret = store.getClientSecret();
		
		GoogleAccessToken response = null;
		WebResource resource = client.resource("https://accounts.google.com");
		Map<String, String> entity = new HashMap<String, String>();
		entity.put("code", code);
		entity.put("client_id", clientId);
		entity.put("client_secret", clientSecret);
		entity.put("redirect_uri", redirectUri.toString());
		entity.put("grant_type", "authorization_code");
		StringBuilder entityBuilder = new StringBuilder();
		
		for ( String key : entity.keySet() )
		{
			entityBuilder.append(String.format("%s=%s&", key, entity.get(key)));
		}
		entityBuilder.substring(0, entityBuilder.length() - 1);
		LOG.debug("\n\tentity : {}", entityBuilder.toString());
		try
		{
			response = resource.path("o/oauth2/token")
								.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
								.accept(MediaType.APPLICATION_JSON_TYPE)
								.entity(entityBuilder.toString())
								.post(GoogleAccessToken.class);
		} 
		catch ( UniformInterfaceException e )
		{
			LOG.debug("\n\tresponse : {}", e.getResponse().getEntity(String.class));
			throw e;
		}
		
		return response;
	}

}

