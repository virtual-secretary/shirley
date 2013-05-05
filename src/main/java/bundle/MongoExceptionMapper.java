package bundle;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoException;
import com.mongodb.MongoException.DuplicateKey;

@Provider
public class MongoExceptionMapper implements ExceptionMapper<MongoException.DuplicateKey>
{
	private Logger LOG = LoggerFactory.getLogger(MongoExceptionMapper.class);
	
	@Override
	public Response toResponse(DuplicateKey e)
	{
		LOG.error(e.getMessage(), e);
		return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).type("text/plain").build();
	}

}
