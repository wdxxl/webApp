package com.wdxxl.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import com.wdxxl.dao.IAppUserDao;
import com.wdxxl.model.AppUser;

@Repository("appUserDao")
public class AppUserDaoImplHibernate implements IAppUserDao {

	public AppUser getAppUserByLoginName(String loginName) {
		// TODO Database to retrieve login user data.
		AppUser appUser = new AppUser();
		appUser.setLoginName(loginName);
		
		return appUser;
	}

}
