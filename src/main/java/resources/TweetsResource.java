package resources;

import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import daos.TwitterTweetsDAO;
@Path("tweets")
public class TweetsResource {
	private final TwitterTweetsDAO tweetsDAO;
	public TweetsResource(TwitterTweetsDAO tweetsDAO){
		this.tweetsDAO = tweetsDAO;
	}
	@Path("/{username}")
	public List<Tweet> getTweets(@PathParam("username") String username){
		return tweetsDAO.RecentTweets(username).get();
	}
}
