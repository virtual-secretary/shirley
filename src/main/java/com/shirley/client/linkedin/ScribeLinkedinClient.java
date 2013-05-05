package com.shirley.client.linkedin;

import java.io.IOException;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.LinkedInApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sun.jersey.api.client.Client;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ScribeLinkedinClient
{
	private static final String PROTECTED_RESOURCE_URL = "http://api.linkedin.com/v1/people/~/connections:(id,last-name)?format=json";
	private Response response;
	private final Client client;
	
	public ScribeLinkedinClient(Client client) {
		super();
		this.client = client;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public static String getProtectedResourceUrl() {
		return PROTECTED_RESOURCE_URL;
	}
	
	@Override
	public UserInfo extractUserInfo() {
		OAuthService service = new ServiceBuilder()
		.provider(LinkedInApi.class)
		.apiKey("veffajn4yiim")
		.apiSecret("7HnDNngrRzMmiCbF")
		.build();
		
		//obtain token
		Token requestToken = service.getRequestToken();
		Verifier verifier = new Verifier(service.getAuthorizationUrl(requestToken));
		
		//trade request key and verifier for access token
		Token accessToken = service.getAccessToken(requestToken, verifier);
		OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
		
		//protect resources
		service.signRequest(accessToken, request);
	    response = request.send();
	   
	    LinkedInClientResponse linkedinClientResponse;
	    try
	    {
	    	linkedinClientResponse = mapper.readValue(response.getBody().trim(), LinkedinClientResponse.class);
			return linkedinClientResponse.getResultCount() == 1 ? linkedinClientResponse.getResults().get(0) : null;
		} 
	    catch (JsonParseException ignore) {}
		catch (JsonMappingException ignore) {}
		catch (IOException ignore) {}
		
		return null;
	   
	}
}