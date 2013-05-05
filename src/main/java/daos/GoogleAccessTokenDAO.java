package daos;

import models.GoogleAccessToken;

public interface GoogleAccessTokenDAO
{
	GoogleAccessToken findByUser(String userId);
	boolean save(GoogleAccessToken token);
	boolean update(GoogleAccessToken token);
	boolean remove(GoogleAccessToken token);
}
