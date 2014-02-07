package com.wdxxl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wdxxl.dao.impl.AppUserDaoImpl;
import com.wdxxl.domain.AppUser;
import com.wdxxl.service.IAppUserService;

@Service
public class AppUserServiceImpl implements IAppUserService {

	@Autowired
	private AppUserDaoImpl appUserDao;

	public AppUser getAppUserByLoginName(String loginName) {
		return appUserDao.getAppUserByLoginName(loginName);
	}
	
}
