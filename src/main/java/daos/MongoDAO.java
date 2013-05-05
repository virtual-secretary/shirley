package daos;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.mongojack.DBCursor;
import org.mongojack.DBQuery;
import org.mongojack.DBUpdate;
import org.mongojack.Id;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Optional;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.WriteConcern;

/**
 * 
 * DAO implementation of Mongo DB.
 * It provides concrete implementation for given T
 *
 * Copyright adConnect Inc. All rights reserved.
 * 
 * @version v0.0.0
 * @since Oct 9, 2012
 * @author rex
 * @param <T>
 */
public abstract class MongoDAO<T> implements DAO<String, T>
{
	protected final static Logger LOG = LoggerFactory.getLogger(MongoDAO.class);
//	private final static String USER_COLL = "users";
	
	protected final Mongo mongo;
	protected final String dbName;
	protected final String collName;
	protected final DB db;
	protected final DBCollection coll;
	protected final JacksonDBCollection<T, String> jackColl;
	private final Class<T> klass;
	
	protected MongoDAO(final Mongo mongo, final String db, final String collName, Class<T> klass)
	{
		this.klass = klass;
		this.mongo = mongo;
		this.dbName = db;
		this.collName = collName;
		this.db = this.mongo.getDB(dbName);
		coll = this.db.getCollection(this.collName);
		jackColl = JacksonDBCollection.wrap(coll, klass, String.class);
		setWriteConcern(WriteConcern.SAFE);
	}
	
	protected void setWriteConcern(WriteConcern concern)
	{
		jackColl.setWriteConcern(WriteConcern.SAFE);
	}
	
	protected DBObject sortOrder(SortOrderPairSet sorts)
	{
		DBObject object = new BasicDBObject();
		for ( SortOrderPair pair : sorts )
		{
//			System.out.println(pair.getField() + " " + pair.getOrder());
			object.put(pair.getField(), pair.getOrder().value());
		}
		return object;
	}
	
	/**
	 * DBQuery that contains declared field of given Type T
	 * This makes sure that Query results will not contain super class
	 * @return DBQuery.Query
	 */
	protected DBQuery.Query[] checkFieldsQuery()
	{
		Field[] fields = klass.getDeclaredFields();
		List<DBQuery.Query> querys = new ArrayList<DBQuery.Query>();  
		for ( Field f : fields )
		{
			JsonProperty jsonProperty = f.getAnnotation(JsonProperty.class);
			Id id = f.getAnnotation(Id.class);
			f.setAccessible(true);
			
			if ( id != null )
			{
				querys.add(DBQuery.exists("_id"));
			}
			else if ( jsonProperty != null )
			{
				String fieldName = jsonProperty.value();
				if ( fieldName == null || fieldName.isEmpty() )
				{
					fieldName = f.getName();
				}
				querys.add(DBQuery.exists(fieldName));
			}
			
		}
		DBQuery.Query[] arrays = new DBQuery.Query[querys.size()];
		
		arrays = querys.toArray(arrays);
		return arrays;
	}
	
	public abstract void setUpIndex();
	
	public String getDBName()
	{
		return dbName;
	}
	
	public String getCollName()
	{
		return collName;
	}

	@Override
	public Optional<List<T>> find()
	{
		DBCursor<T> cur = jackColl.find().or(checkFieldsQuery());
		List<T> results = cur.toArray();
		return Optional.of(results);
	}
	
	@Override
	public Optional<List<T>> find(SortOrderPairSet sorts)
	{
		
		DBCursor<T> cur = jackColl.find().or(checkFieldsQuery()).sort(sortOrder(sorts));
		List<T> results = cur.toArray();
		return Optional.of(results);
	}

	@Override
	public Optional<List<T>> findN(int n)
	{
		DBCursor<T> cur = jackColl.find().or(checkFieldsQuery()).limit(n);
		List<T> results = cur.toArray();
		return Optional.of(results);
	}
	
	@Override
	public Optional<List<T>> findPage(int page, int num)
	{
		DBCursor<T> cur = jackColl.find().or(checkFieldsQuery()).skip((page - 1) * num).limit(num);
		List<T> results = cur.toArray();
		return Optional.of(results);
	}
	
	@Override
	public Optional<List<T>> findPage(int page, int num, SortOrderPairSet sorts)
	{
		DBCursor<T> cur = jackColl.find().or(checkFieldsQuery())
										 .skip((page - 1) * num)
										 .limit(num)
										 .sort(sortOrder(sorts));
		List<T> results = cur.toArray();
		return Optional.of(results);
	}

	@Override
	public Optional<T> findOneById(String id)
	{
		T T = jackColl.findOneById(id);
		return Optional.fromNullable(T);
	}

	@Override
	public Optional<String> insert(T obj)
	{
		WriteResult<T, String> wr = jackColl.insert(obj);
		return Optional.of(wr.getSavedId());
	}
	
	@Override
	public Optional<List<String>> insert(List<T> obj)
	{
		WriteResult<T, String> wr = jackColl.insert(obj);
		List<String> ids = wr.getSavedIds();
		if ( ids.size() == 0)
		{
			return Optional.absent();
		}
		
		return Optional.of(ids);
	}
	
	/**
	 * Save has might remove all super object fields that is not specified in given model object but exists in the collections
	 * Use it with care 
	 */
	@Override
	public Optional<String> save(T obj)
	{
		WriteResult<T, String> wr = jackColl.save(obj);
		return Optional.of(wr.getSavedId());
	}

	@Override
	public Optional<List<String>> save(List<T> obj)
	{
		List<String> result = new ArrayList<String>();
		for ( T t : obj )
		{
			Optional<String> savedId = save(t);
			if ( savedId.isPresent() )
			{
				result.add(savedId.get());
			}
		}
		
		if ( result.size() == 0 )
		{
			return Optional.absent();
		}
		else
		{
			return Optional.of(result);
		}
		
	}

	/* update */
	
	@Override
	public boolean updateById(String id, T obj)
	{
		DBUpdate.Builder builder = new UpdateBuilder(obj).build();
		WriteResult<T, String> wr = jackColl.updateById(id, builder);
		if ( wr.getError() != null && !wr.getError().isEmpty() )
		{
			LOG.error(wr.getError());
		}
		return wr.getN() == 1;
	}
	
	public boolean increment(String id, String field, int value)
	{
		WriteResult<T, String> wr = jackColl.updateById(id, new DBUpdate.Builder().inc(field, value));
		return wr.getN() == 1;
	}
	
	public boolean decrement(String id, String field, int value)
	{
		return increment(id, field, -1 * value);
	}

	@Override
	public boolean removeById(String id)
	{
		WriteResult<T, String> wr = jackColl.removeById(id);
		if ( wr.getError() != null && !wr.getError().isEmpty() )
		{
			LOG.error(wr.getError());
		}
		return wr.getN() == 1;
	}	
	
	@Override
	public boolean removeObject(T obj)
	{
		WriteResult<T, String> wr = jackColl.remove(obj);
		if ( wr.getError() != null && !wr.getError().isEmpty() )
		{
			LOG.error(wr.getError());
		}
		return wr.getN() == 1;
	}
}
