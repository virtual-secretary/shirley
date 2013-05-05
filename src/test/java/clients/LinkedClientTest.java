package clients;

import static com.yammer.dropwizard.testing.JsonHelpers.asJson;

import java.util.Date;

import org.junit.Test;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthService;
import com.google.code.linkedinapi.client.oauth.LinkedInOAuthServiceFactory;
import com.google.code.linkedinapi.client.oauth.LinkedInRequestToken;
import com.google.code.linkedinapi.schema.Person;

public class LinkedClientTest
{
	@Test
	public void test() throws Exception
	{
		final LinkedInOAuthService oauthService = LinkedInOAuthServiceFactory.getInstance().createLinkedInOAuthService("veffajn4yiim", "7HnDNngrRzMmiCbF");
//		LinkedInRequestToken requestToken = oauthService.getOAuthRequestToken();
//		System.out.println(asJson(requestToken));
//		LinkedInRequestToken requestToken = new LinkedInRequestToken("9d7596de-27e7-46ea-a7d1-ae85f20b7697", "7ea1f9d2-14d3-45f7-a7aa-797533425768");
//		requestToken.setExpirationTime(new Date(1367731764354L));
//		requestToken.setAuthorizationUrl("https://www.linkedin.com/uas/oauth/authorize?oauth_token=9d7596de-27e7-46ea-a7d1-ae85f20b7697");
//		LinkedInAccessToken oAuthAccessToken = oauthService.getOAuthAccessToken(requestToken, "00074");
		LinkedInAccessToken oAuthAccessToken = new LinkedInAccessToken("93bc2947-8b36-4ff0-b7a5-f02a24f0c0a0", "f2b532f6-908e-4f1f-b89e-ee4a1d4db20c");
		oAuthAccessToken.setExpirationTime(new Date(1372915180826L));
		
		//00074
		System.out.println(asJson(oAuthAccessToken));
		
		final LinkedInApiClientFactory factory = LinkedInApiClientFactory.newInstance("veffajn4yiim", "7HnDNngrRzMmiCbF");
		LinkedInApiClient client = factory.createLinkedInApiClient(oAuthAccessToken);
		Person person = client.getProfileForCurrentUser();
		System.out.println(asJson(person));
		
	}
}
