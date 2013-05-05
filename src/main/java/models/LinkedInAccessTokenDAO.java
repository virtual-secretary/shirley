package models;

import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;

public interface LinkedInAccessTokenDAO
{
	LinkedInAccessToken getRequestTokenByDeveloper(String userId);
	
	boolean save(String userId, LinkedInAccessToken token);
	
	boolean update(String userId, LinkedInAccessToken token);
	
	boolean remove(String userId);
}
