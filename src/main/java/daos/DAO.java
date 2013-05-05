package daos;

import java.util.List;

import com.google.common.base.Optional;

/**
 * 
 * General interface of database access
 * 
 * Copyright adConnect Inc. All rights reserved.
 * 
 * @version v0.0.0
 * @since Oct 5, 2012
 * @author rex
 * @param <C> Type of key (id)
 * @param <T> Type of object to be retrieve or inserted
 */
public interface DAO<C, T>
{
	/* find */
	/**
	 * Find All T in Database
	 * @return List of T
	 */
	public Optional<List<T>> find();
	
	/**
	 * find collections of T with given SortSorder
	 * @param sorts
	 * @return List of T
	 */
	public Optional<List<T>> find(SortOrderPairSet sorts);
	public Optional<List<T>> findN(int n);
	public Optional<List<T>> findPage(int page, int num);
	public Optional<List<T>> findPage(int page, int num, SortOrderPairSet sorts);
	public Optional<T> findOneById(C id);
	
	/* insert */
	public Optional<C> insert(T obj);
	public Optional<List<C>> insert(List<T> obj);
	
	/* save */
	/**
	 * 
	 * Save operation overwrites existing fields. use this at your own risk
	 * @param obj
	 * @return
	 */
	public Optional<C> save(T obj);
	
	/**
	 * 
	 * Save operation overwrite exsiting fields. use this at your own risk
	 * @param obj
	 * @return
	 */
	public Optional<List<C>> save(List<T> obj);
	
	/* update */
	public boolean updateById(C id, T obj);
	public boolean increment(String id, String field, int value);
	public boolean decrement(String id, String field, int value);
	
	/* remove */
	public boolean removeById(C id);
	public boolean removeObject(T obj);
	
	
}
