package com.wdxxl.service;

import com.wdxxl.model.AppUser;

public interface IAppUserService {
	public AppUser getAppUserByLoginName(String loginName);
}
