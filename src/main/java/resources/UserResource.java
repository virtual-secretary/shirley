package resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import models.UserSettings;
import security.UAuth;
import security.User;
import daos.UserDAO;

@Path("user")
public class UserResource
{
	private UserDAO userDAO;
	
	public UserResource(UserDAO userDAO)
	{
		super();
		this.userDAO = userDAO;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(
			@UAuth User user) throws Exception
	{
		user.setPassword(null);
		return user;
	}
	
	@Path("/settings")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public UserSettings getUserSettings(
			@UAuth User user) throws Exception
	{
		return user.getSetting();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User putUser(
			@UAuth User user,
			User newUser) throws Exception
	{
		newUser.setPassword(user.getPassword());
		boolean result = userDAO.updateById(user.getId(), newUser);
		
		if ( !result )
		{
			new WebApplicationException(Response.Status.NOT_MODIFIED);
		}
		
		newUser.setPassword(null);
		return newUser;
	}
	
	@Path("/settings")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public UserSettings putUserSettings(
			@UAuth User user,
			UserSettings setting) throws Exception
	{
		return user.getSetting();
	}
	
	
}
