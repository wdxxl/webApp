package com.wdxxl.service;

import com.wdxxl.domain.AppUser;

public interface IAppUserService {
	public AppUser getAppUserByLoginName(String loginName);
}
