package com.wdxxl.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.wdxxl.controller.login.LoginedUsers;
import com.wdxxl.utils.Constants;

/**
 * this class used to checking Session Created and Session Destroyed.
 * 
 * @author 
 *
 */
public class SessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		System.out.println("sessionCreated -- "+ (String) httpSessionEvent.getSession().getAttribute(Constants.TOKEN_KEY));
	}

	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		//show logined users
		LoginedUsers.print();
		HttpSession session = httpSessionEvent.getSession();
		String uuid = (String) session.getAttribute(Constants.TOKEN_KEY);
		if (uuid != null) {
			System.out.println("sessionDestroyed-- "+uuid);
			LoginedUsers.removeUser(uuid);
		}
	}
}

