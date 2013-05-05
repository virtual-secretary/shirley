package resources;

import helpers.ResourceHelper;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.mongojack.DBCursor;
import org.mongojack.DBQuery;
import org.mongojack.JacksonDBCollection;

import security.BCrypt;
import security.LoginCookieGeneratorIpml;
import security.User;

import com.mongodb.DB;
import com.yammer.dropwizard.jersey.params.BooleanParam;

@Path("/")
public class RootResource
{
	private DB db;
	private LoginCookieGeneratorIpml generator;
	
	
	public RootResource(DB db, LoginCookieGeneratorIpml generator)
	{
		super();
		this.db = db;
		this.generator = generator;
	}

	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response login(
			@Context HttpServletRequest req,
			@FormParam("username") String username,
			@FormParam("password") String password,
			@FormParam("remember") BooleanParam remember,
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
		String cookie = generator.generateResponse(user, remember == null ? false : remember.get(), req.getRemoteAddr());
		
		// return it
		
		if ( callback != null )
			return Response.seeOther(callback).header("SET-COOKIE", cookie).build();
		else
			return Response.ok().header("SET-COOKIE", cookie).build();
	}
	
	@GET
	@Path("logout")
	public Response getLogout(@CookieParam("VA_SHIRLEY") Cookie tokenCookie) throws Exception
	{
		return postLogout(tokenCookie);
	}
	
	@POST
	@Path("logout")
	public Response postLogout(@CookieParam("VA_SHIRLEY") Cookie tokenCookie) throws Exception
	{
		// Generate cookie destroyer
		String cookie = generator.destroyCookie(tokenCookie.getValue());
		
		return Response.ok().header("SET-COOKIE", cookie).build();
	}
	
}
