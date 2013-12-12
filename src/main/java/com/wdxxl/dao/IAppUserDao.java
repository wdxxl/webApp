package com.wdxxl.dao;

import com.wdxxl.model.AppUser;

public interface IAppUserDao {
	public AppUser getAppUserByLoginName(String loginName);
}
