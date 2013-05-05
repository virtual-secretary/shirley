package resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import models.TwitterProfile;
import daos.TwitterProfileDAO;
@Path("/twitterProfile")
public class TwitterProfileResource {
	protected TwitterProfileDAO twitterProfileDAO;
	public TwitterProfileResource(TwitterProfileDAO twitterProfileDAO){
		this.twitterProfileDAO = twitterProfileDAO;
	}
	@GET
	@Path("/{username}")
	public TwitterProfile getUser(@PathParam("username") String username){
		return twitterProfileDAO.findWithUsername(username).get();
	}
	@GET 
	@Path("/followed/{username}")
	public boolean getFollowed(@PathParam("username")String username){
		return twitterProfileDAO.hasFollowed(username);
	}
}
