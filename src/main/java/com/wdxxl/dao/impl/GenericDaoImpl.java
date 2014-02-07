package com.wdxxl.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wdxxl.dao.Hibernate4GenericDao;
import com.wdxxl.dao.IGenericDao;

public class GenericDaoImpl<T extends Serializable, ID extends Serializable> 
extends Hibernate4GenericDao implements IGenericDao<T,ID>{
	protected Class<T> clazz;  
	  
    @SuppressWarnings("unchecked")  
    public GenericDaoImpl() {  
        this.clazz = (Class<T>) ((ParameterizedType) getClass()  
                .getGenericSuperclass()).getActualTypeArguments()[0];  
    }
 
	public GenericDaoImpl(Class<T> clazz) {  
        this.clazz = clazz;
    }

	@Override
	@SuppressWarnings("unchecked")
	public T findById(ID id) {
		return (T) getSession().get(clazz, id);
	}

	@Override
	public void save(T entity) {
		this.getSession().saveOrUpdate(entity);
	}
	
	@Override
	public void saveAll(Collection<T> entities) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(T entity) {
		this.getSession().delete(entity);
	}

	@Override
	public void deleteById(ID id) {
		
	}

	@Override
	public T merge(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByHQL(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByCriteria(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int rowCountByCriteria(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
