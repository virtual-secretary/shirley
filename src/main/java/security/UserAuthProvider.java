package security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.api.model.Parameter;
import com.sun.jersey.core.spi.component.ComponentContext;
import com.sun.jersey.core.spi.component.ComponentScope;
import com.sun.jersey.spi.inject.Injectable;
import com.sun.jersey.spi.inject.InjectableProvider;
import com.yammer.dropwizard.auth.Authenticator;
import com.yammer.dropwizard.auth.basic.BasicAuthProvider;
import com.yammer.dropwizard.auth.basic.BasicCredentials;

public class UserAuthProvider<T>  implements InjectableProvider<UAuth, Parameter> 
{
    static final Logger LOG = LoggerFactory.getLogger(UserAuthProvider.class);

    private final Authenticator<String, T> authenticator;
    private final String realm;

    /**
     * Creates a new {@link BasicAuthProvider} with the given {@link Authenticator} and realm.
     *
     * @param authenticator    the authenticator which will take the {@link BasicCredentials} and
     *                         convert them into instances of {@code T}
     * @param realm            the name of the authentication realm
     */
    public UserAuthProvider(Authenticator<String, T> authenticator, String realm)
    {
        this.authenticator = authenticator;
        this.realm = realm;
    }

    @Override
    public ComponentScope getScope() {
        return ComponentScope.PerRequest;
    }

    @Override
    public Injectable<?> getInjectable(ComponentContext ic,
                                       UAuth a,
                                       Parameter c) {
    	return new UserAuthInjectable<T>(authenticator, realm, a.required());
    }
}
