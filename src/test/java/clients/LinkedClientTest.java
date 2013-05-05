package clients;

import static com.yammer.dropwizard.testing.JsonHelpers.asJson;

import org.junit.Test;

import com.google.code.linkedinapi.client.oauth.LinkedInOAuthService;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthServiceFactory;
import com.google.code.linkedinapi.client.oauth.LinkedInRequestToken;

public class LinkedClientTest
{
	@Test
	public void test() throws Exception
	{
		final LinkedInOAuthService oauthService = LinkedInOAuthServiceFactory.getInstance().createLinkedInOAuthService("veffajn4yiim", "7HnDNngrRzMmiCbF");
		
		LinkedInRequestToken requestToken = oauthService.getOAuthRequestToken();
		System.out.println(asJson(requestToken));
//		LinkedInRequestToken requestToken = new LinkedInRequestToken("97d4a44d-48ad-40ae-a671-104830a3d3a3", "6e835828-0144-4389-a68a-08b6cedf5b58");
//		requestToken.setExpirationTime(new Date(1367750081682L));
//		requestToken.setAuthorizationUrl("https://www.linkedin.com/uas/oauth/authorize?oauth_token=97d4a44d-48ad-40ae-a671-104830a3d3a3");
//		LinkedInAccessToken oAuthAccessToken = oauthService.getOAuthAccessToken(requestToken, "98409");
//		LinkedInAccessToken oAuthAccessToken = new LinkedInAccessToken("93bc2947-8b36-4ff0-b7a5-f02a24f0c0a0", "f2b532f6-908e-4f1f-b89e-ee4a1d4db20c");
//		oAuthAccessToken.setExpirationTime(new Date(1372932774142L));
//		
//		//00074
//		System.out.println(asJson(oAuthAccessToken));
//		
//		final LinkedInApiClientFactory factory = LinkedInApiClientFactory.newInstance("veffajn4yiim", "7HnDNngrRzMmiCbF");
//		LinkedInApiClient client = factory.createLinkedInApiClient(oAuthAccessToken);
//		Person person = client.getProfileForCurrentUser();
//		System.out.println(asJson(person));
//		
//		Map<SearchParameter, String> searchParameters = new EnumMap<SearchParameter, String>(SearchParameter.class);
//		searchParameters.put(SearchParameter.FIRST_NAME, "Aflred");
//		searchParameters.put(SearchParameter.COMPANY_NAME, "Appfuel");
//		People searchPeople = client.searchPeople(searchParameters);
//		
//		System.out.println(asJson(searchPeople));
		
	}
}
