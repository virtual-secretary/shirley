package clients;

import static com.yammer.dropwizard.testing.JsonHelpers.asJson;

import org.junit.Test;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;

public class TwitterClientTest
{
	@Test
	public void test() throws Exception
	{
		Twitter twitter = TwitterFactory.getSingleton();
		twitter.setOAuthConsumer("0BRsjcxPE3snL06eqXW8A", "zdRP1SBSsH08jArP4UM39imiynRa9KdYuDGatw6c");
		
		RequestToken oAuthRequestToken = twitter.getOAuthRequestToken();
		System.out.println(asJson(oAuthRequestToken));
//		System.out.println();
//		twitter.setOAuthAccessToken(new AccessToken("155464496-x6kwTLd511uRqUKYW3Jsq7gx7rcEF924GKeRFebj", "JHoO7rML9aPGQcXZGoJ3gVgOtXFyTJZYSCIcni1ncw"));
//		ResponseList<User> searchUsers = twitter.searchUsers("Andrew Boos", 0);
//		System.out.println(asJson(searchUsers));
	}
}
