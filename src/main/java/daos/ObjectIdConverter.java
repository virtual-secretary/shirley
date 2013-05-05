package daos;

import java.util.Date;

import org.bson.types.ObjectId;

public class ObjectIdConverter
{
	public ObjectId convert(Object o)
	{
		final Class<?> klass = o.getClass();
		
		if ( klass == ObjectId.class)
		{
			return ObjectId.class.cast(o);
		}
		
		if ( klass == String.class )
		{
			return new ObjectId(String.class.cast(o));
		}
		
		if ( klass == Date.class )
		{
			return new ObjectId(Date.class.cast(o), 0);
		}
		
		return null;
	}
}
