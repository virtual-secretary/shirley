package resources;

import helpers.ResourceHelper;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.mongojack.DBCursor;
import org.mongojack.DBQuery;
import org.mongojack.JacksonDBCollection;

import security.BCrypt;
import security.LoginCookieGeneratorIpml;
import security.User;

import com.mongodb.DB;
import com.mongodb.Mongo;

@Path("/")
public class RootResource
{
	private Mongo m;
	private DB db;
	private LoginCookieGeneratorIpml generator;
	
	@Path("login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response login(
			@Context HttpServletRequest req,
			@FormParam("username") String username,
			@FormParam("password") String password,
			@FormParam("remember") boolean remember,
			@FormParam("callback") URI callback) throws Exception
	{
		JacksonDBCollection<User, String> coll = JacksonDBCollection.wrap(db.getCollection("users"), User.class, String.class);
		DBCursor<User> find = coll.find(DBQuery.or(DBQuery.in("emails", username), DBQuery.is("name", username)));
		
		ResourceHelper.AuthenticaErrorIfNotTrue(find.hasNext());
		
		User user = find.next();
		
		// Verify username and password 
		String hashed = user.getPassword();
		boolean checkpw = BCrypt.checkpw(password, hashed);
		
		ResourceHelper.AuthenticaErrorIfNotTrue(checkpw);
		
		// generate LoginCookie
		String cookie = generator.generateResponse(user, remember, req.getRemoteAddr());
		
		// return it
		return Response.seeOther(callback).header("SET-COOKIE", cookie).build();
	}
	
	@Path("logout")
	public void logout() throws Exception
	{
		//TODO::
	}
	
}
