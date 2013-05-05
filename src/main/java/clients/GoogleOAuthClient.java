package clients;
import java.net.URI;
import java.util.Set;

import tokens.GoogleAccessToken;


public interface GoogleOAuthClient
{
	Set<String> getEmails(String token);
	GoogleAccessToken getAccessToken(final String code, final URI redirectUri);
}
