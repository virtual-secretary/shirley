package daos;

import twitter4j.auth.RequestToken;

public interface TwitterRequestTokenDAO
{
	RequestToken findByUser(String userId);
	boolean save(String userId, RequestToken  token);
	boolean update(String userId, RequestToken token);
	boolean remove(String userId);
}
