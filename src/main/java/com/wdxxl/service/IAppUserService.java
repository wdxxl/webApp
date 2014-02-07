package com.wdxxl.service;

import com.wdxxl.domain.AppUser;

public interface IAppUserService {
	AppUser getAppUserByLoginName(String loginName);
}
