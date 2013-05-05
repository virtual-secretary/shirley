package security;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.common.base.Optional;
import com.sun.jersey.api.core.HttpContext;
import com.sun.jersey.server.impl.inject.AbstractHttpContextInjectable;
import com.yammer.dropwizard.auth.AuthenticationException;
import com.yammer.dropwizard.auth.Authenticator;

class UserAuthInjectable<T> extends AbstractHttpContextInjectable<T>
{
//	private static final Log LOG = Log.forClass(UserAuthInjectable.class);
	private static final String TOKEN_HEADER = "VA_SHIRLEY";
	private static final String HEADER_NAME = "WWW-Authenticate";
    private static final String HEADER_VALUE = "realm=\"%s\"";

    private final Authenticator<String, T> authenticator;
    private final String realm;
    private final boolean required;
    
    public UserAuthInjectable(Authenticator<String, T> authenticator, String realm, boolean required) 
    {
        this.authenticator = authenticator;
        this.realm = realm;
        this.required = required;
    }
	
    public Authenticator<String, T> getAuthenticator() 
    {
        return authenticator;
    }

    public String getRealm() 
    {
        return realm;
    }

    public boolean isRequired() 
    {
        return required;
    }
    
	@Override
	public T getValue(HttpContext c)
	{
		final Cookie tokenCookie = c.getRequest().getCookies().get(TOKEN_HEADER);
		try {
			if ( tokenCookie != null )
			{
				// Cookie does not exists wrong credentials
				final String token = tokenCookie.getValue();
				if (token != null) {
					final Optional<T> result = authenticator.authenticate(token);
					if ( result.isPresent() )
					{
						return result.get();
					}
				}
			}
        } catch (IllegalArgumentException e) {
        	UserAuthProvider.LOG.debug("Error decoding credentials", e);
        } catch (AuthenticationException e) {
        	if ( required )
        	{
        		UserAuthProvider.LOG.warn("Error authenticating credentials", e);
        		throw new WebApplicationException(Response.status(Response.Status.UNAUTHORIZED)
									                        .header(HEADER_NAME,
									                                String.format(HEADER_VALUE, realm))
									                        .entity("Credentials are required to access this resource.")
									                        .type(MediaType.TEXT_PLAIN_TYPE)
									                        .build());
        	}
        }

        if (required) {
            throw new WebApplicationException(Response.status(Response.Status.UNAUTHORIZED)
                                                      .header(HEADER_NAME,
                                                              String.format(HEADER_VALUE, realm))
                                                      .entity("Credentials are required to access this resource.")
                                                      .type(MediaType.TEXT_PLAIN_TYPE)
                                                      .build());
        }
        return null;
	}

}
