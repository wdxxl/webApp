package com.wdxxl.dao;

import java.util.List;

import com.wdxxl.domain.AppUser;

public interface IAppUserDao {
	public AppUser getAppUserByLoginName(String loginName);
	public List<AppUser> getAppUserList();
}
