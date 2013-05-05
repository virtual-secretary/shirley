package daos;

import com.google.common.base.Optional;

import models.TwitterProfile;


public interface TwitterProfileDAO extends DAO<String,TwitterProfile>
{
	public Optional<TwitterProfile> findWithUsername(String username);
	boolean hasFollowed(String username);
	
}
