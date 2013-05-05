package bundle;

import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoException;
import com.yammer.dropwizard.jersey.LoggingExceptionMapper;

@Provider
public class LoggingMongoExceptionMapper extends LoggingExceptionMapper<MongoException>
{
	private static final Logger LOG = LoggerFactory.getLogger(LoggingMongoExceptionMapper.class);

	@Override
    protected void logException(long id, MongoException exception) 
	{
        final String message = formatLogMessage(id, exception);
        LOG.error(message, exception);
    }
}
