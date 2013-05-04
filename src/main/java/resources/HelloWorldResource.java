package resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class HelloWorldResource
{
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getHelloWorld()
	{
		return "hello world";
	}
}
