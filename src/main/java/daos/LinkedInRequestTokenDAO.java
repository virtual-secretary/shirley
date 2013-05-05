package daos;

import com.google.code.linkedinapi.client.oauth.LinkedInRequestToken;

public interface LinkedInRequestTokenDAO
{
	LinkedInRequestToken getRequestTokenByDeveloper(String userId);
	
	boolean save(String userId, LinkedInRequestToken token);
	
	boolean remove(String userId);
	
	
}
