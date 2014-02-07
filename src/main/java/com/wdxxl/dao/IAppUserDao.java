package com.wdxxl.dao;

import java.util.List;

import com.wdxxl.domain.AppUser;

public interface IAppUserDao {
	AppUser getAppUserByLoginName(String loginName);
	List<AppUser> getAppUserList();
	void saveAppUser(AppUser appUser);
}
