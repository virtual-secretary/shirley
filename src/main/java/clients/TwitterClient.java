package clients;

import models.TwitterProfile;

public interface TwitterClient
{
	TwitterProfile getProfile(String twitterAccountName);
}
