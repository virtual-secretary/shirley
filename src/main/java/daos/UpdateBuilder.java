package daos;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.mongojack.DBUpdate;
import org.mongojack.Id;
import org.mongojack.ObjectId;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * Builds Mongo specific DBUpdateBuilder
 * 
 * sets individual fields if field is not null
 *
 * Copyright adConnect Inc. All rights reserved.
 * 
 * @version v0.0.0
 * @since Oct 8, 2012
 * @author rex
 */
public class UpdateBuilder
{
	private DBUpdate.Builder builder;
	private final Object obj;
	
	public UpdateBuilder(Object obj)
	{
		this.obj = obj;
		builder = new DBUpdate.Builder(); 
	}
	
	protected List<Field> extractFields(Class<?> klass)
	{
		List<Field> fields = new ArrayList<Field>();
		while ( klass != Object.class )
		{
			Field[] extracted = klass.getDeclaredFields();
			for ( Field f : extracted )
			{
				fields.add(f);
			}
			klass = klass.getSuperclass();
		}
		
		return fields;
	}
	
	public DBUpdate.Builder build()
	{
		List<Field> fields = extractFields(obj.getClass());
		try
		{
			for ( Field f : fields )
			{
				JsonProperty jsonProperty = f.getAnnotation(JsonProperty.class);
				ObjectId objectId = f.getAnnotation(ObjectId.class);
				Id id = f.getAnnotation(Id.class);
				f.setAccessible(true);
				
				// Id must not be set
				if ( id == null )
				{
					if ( jsonProperty != null )
					{
						String fieldName = jsonProperty.value();
						if ( fieldName == null || fieldName.isEmpty() )
						{
							fieldName = f.getName();
						}
						// _id field must not be mapped
						if ( !fieldName.equals("_id") )
						{
							Object value;
							if ( objectId != null )
							{
								value = new ObjectIdConverter().convert(f.get(obj));
							}
							else
							{
								value = f.get(obj);
							}
							
							if ( value != null )
							{
								builder = builder.set(fieldName, value);
							}
							else
							{
								builder = builder.unset(fieldName);
							}
						}
					}
					
				}
				
			}
		}

		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
			return null;
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
			return null;
		}
		return builder;
	}
}
