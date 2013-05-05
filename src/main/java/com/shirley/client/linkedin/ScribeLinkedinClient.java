package com.shirley.client.linkedin;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.LinkedInApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;

public class ScribeLinkedinClient implements LinkedinClient {
	//private final String PROTECTED_RESOURCE_URL = "http://api.linkedin.com/v1/people/~/people/";
	/* this one works */
	//private final String PROTECTED_RESOURCE_URL = "http://api.linkedin.com/v1/people/~:(id)?format=json";
	
	//nR4pZOXFHY is my ID, here is an example usage
	private final String PROTECTED_RESOURCE_URL = "http://api.linkedin.com/v1/people::(nR4pZOXFHY):(first-name,last-name,summary,headline)?format=json";
	
	//private final String JSON_FORMAT ="?format=json";
	private Response response;
	private final Client client;
	
	
	public ScribeLinkedinClient(Client client) {
		super();
		this.client = client;
	}
	
	@Override   /*String url is not in use rite now */
	public List<Person> extractPerson(String url) {
		Scanner in = new Scanner(System.in);
		ObjectMapper mapper = new ObjectMapper();
		
		OAuthService service = new ServiceBuilder()
		.provider(LinkedInApi.class)
		.apiKey("veffajn4yiim")
		.apiSecret("7HnDNngrRzMmiCbF")
		.build();
		
		//obtain token
		Token requestToken = service.getRequestToken();
		
		/*
		URI tokenURL = UriBuilder.fromUri(service.getAuthorizationUrl(requestToken)).build();
		
		String _token = tokenURL.getQuery().replace("oauth_token=", "");
	
		Verifier verifier = new Verifier(_token);
		
		System.out.println(requestToken);
		System.out.println(_token);
		*/
		
		System.out.println("Now go and authorize Scribe here:");
	    System.out.println(service.getAuthorizationUrl(requestToken));
	    System.out.println("And paste the verifier here");
	    System.out.print(">>");
	    Verifier verifier = new Verifier(in.nextLine());
	    System.out.println();
		
		//trade request key and verifier for access token
		Token accessToken = service.getAccessToken(requestToken, verifier);
		
		System.out.println(accessToken);
		
		OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);//PROTECTED_RESOURCE_URL+url+JSON_FORMAT);
		
		//protect resources
		service.signRequest(accessToken, request);
	    response = request.send();
	   
	    LinkedInClientResponse linkedinClientResponse;
	    System.out.println(response.getBody().trim());
	    try
	    {
	    	//System.out.println("response.getBody().trim()");
	    	linkedinClientResponse = mapper.readValue(response.getBody().trim(), LinkedInClientResponse.class);
			//return linkedinClientResponse.getResultCount() == 1 ? linkedinClientResponse.getResults().get(0) : null;
	    	return linkedinClientResponse.getResults();
		} 
	    catch (JsonParseException ignore) {}
		catch (JsonMappingException ignore) {}
		catch (IOException ignore) {}
		
	    System.out.println("Failed to parse");
		return null;
	   
	}
}