package com.wdxxl.dao.hibernate.impl;

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
public class AppUserDaoImplHibernate implements IAppUserDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public AppUser getAppUserByLoginName(String loginName) {
		Session session = sessionFactory.openSession();
		Criteria criteria =  session.createCriteria(AppUser.class);
		criteria.add(Restrictions.like("loginName", loginName));
		
		List<AppUser> appUserList = criteria.list();
		if(appUserList.isEmpty()){
			session.close();
			return null;
		}else{
			AppUser appUser = appUserList.get(0);
			session.close();
			return appUser;
		} 
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AppUser> getAppUserList() {
		Session session = sessionFactory.openSession();
		Criteria criteria =  session.createCriteria(AppUser.class);
		List<AppUser> appUserList = criteria.list();
		return appUserList;
	}
}
