package helpers;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class ResourceHelper
{
	public static void AuthenticaErrorIfNotTrue(boolean check)
	{
		if ( check )
		{
			return;
		}
		new WebApplicationException(Response.Status.UNAUTHORIZED);
	}
}	
