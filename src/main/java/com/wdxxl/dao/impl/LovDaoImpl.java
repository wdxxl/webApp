package com.wdxxl.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.wdxxl.dao.ILovDao;
import com.wdxxl.domain.Lov;

@Repository("lovDao")
public class LovDaoImpl extends GenericDaoImpl<Lov, Integer> implements ILovDao {
	@Override
	public Lov getLovById(Integer id) {
		Lov lov = findById(id);
		return lov;
	}

	@Override
	public void saveLov(Lov lov) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(lov);
	}
}
