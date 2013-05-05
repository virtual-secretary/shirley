package daos;

import java.util.List;

import com.google.common.base.Optional;

public interface TwitterTweetsDAO extends DAO<String,Tweet>{
	public Optional<List<Tweet>>RecentTweets(String username);
	
	

}
