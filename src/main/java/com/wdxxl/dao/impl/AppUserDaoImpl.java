package com.wdxxl.dao.impl;

import java.util.List;

import com.wdxxl.dao.IAppUserDao;
import com.wdxxl.domain.AppUser;

public class AppUserDaoImpl implements IAppUserDao {

	public AppUser getAppUserByLoginName(String loginName) {
		// TODO Database to retrieve login user data.
		AppUser appUser = new AppUser();
		appUser.setLoginName(loginName);
		
		return appUser;
	}

	@Override
	public List<AppUser> getAppUserList() {
		// TODO Auto-generated method stub
		return null;
	}

}
