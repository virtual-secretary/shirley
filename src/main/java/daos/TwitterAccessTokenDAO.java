package daos;

import twitter4j.auth.AccessToken;

public interface TwitterAccessTokenDAO
{
	AccessToken findByUser(String userId);
	boolean save(String userId, AccessToken  token);
	boolean update(String userId, AccessToken token);
	boolean remove(String userId);
}
