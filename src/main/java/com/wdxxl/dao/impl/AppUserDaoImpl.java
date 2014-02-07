package com.wdxxl.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wdxxl.dao.IAppUserDao;
import com.wdxxl.domain.AppUser;

@Repository("appUserDao")
public class AppUserDaoImpl implements IAppUserDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public AppUser getAppUserByLoginName(String loginName) {
		Session session = sessionFactory.openSession();
		Criteria criteria =  session.createCriteria(AppUser.class);
		criteria.add(Restrictions.like("loginName", loginName));
		List<AppUser> appUserList = criteria.list();
		session.close();
		return appUserList.isEmpty()? null:appUserList.get(0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AppUser> getAppUserList() {
		Session session = sessionFactory.openSession();
		Criteria criteria =  session.createCriteria(AppUser.class);
		List<AppUser> appUserList = criteria.list();
		session.close();
		return appUserList;
	}

	@Override
	public void saveAppUser(AppUser appUser) {
		//openSession is not work when saveOrUpdate one records.
		//Session session = sessionFactory.openSession();
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(appUser);
	}
}
