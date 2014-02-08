package com.wdxxl.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
/**
 * A GenericDAO is the root interface for DAOs.  This
 * defines base functionality such as finding a specific entity by its identifier and saving an
 * entity to the underlying data store.
 *
 * @param <T> Type of entity
 * @param <ID> ID type for the entity.
 */
public interface IGenericDao <T extends Serializable, ID extends Serializable>{
	/**
     * Find an object T with the specified id.
     * @param id of the desired object.
     * @return Object with the specified id
     */
	T findById(ID id);
    
    /**
     * Call save to insert a new object into the persistent store or update a preexisting object that has
     * been modified.
     * @param entity to save.
     */
	void save(T entity);
	void saveAll(Collection<T> entities);
	/**
     * Delete the specified object from the persistent store.
     *
     * @param entity to delete.
     */
	void delete(T entity);
	void deleteById(ID id);
	
	T merge(T entity);
	
	List<T> findByHQL(String hql);
	List<T> findByCriteria(DetachedCriteria criteria);
	int rowCountByCriteria(DetachedCriteria criteria);
}
