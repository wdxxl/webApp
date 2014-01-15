package com.wdxxl.controller.login;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.wdxxl.domain.AppUser;
import com.wdxxl.utils.Constants;


public final class LoginedUsers {
	
	private Lock lock;
	
	private Map<String, AppUser> loginedUsers;
	
	private static LoginedUsers sharedInstance = new LoginedUsers();
	
	private LoginedUsers() {
		loginedUsers = new HashMap<String, AppUser>();
		lock = new ReentrantLock();
	}
	
	public static void setUser(String uuid, AppUser user) {
		try {
			sharedInstance.lock.lock();
			sharedInstance.loginedUsers.put(uuid, user);
		} finally {
			sharedInstance.lock.unlock();
		}
	}
	
	public static void removeUser(String uuid) {
		try {
			sharedInstance.lock.lock();
			sharedInstance.loginedUsers.remove(uuid);
		} finally {
			sharedInstance.lock.unlock();
		}
	}
	
	public static AppUser getUser(String uuid) {
		try {
			sharedInstance.lock.lock();
			return sharedInstance.loginedUsers.get(uuid);
		} finally {
			sharedInstance.lock.unlock();
		}
	}
	
	/**
	 * used in Filter to check weather this user is logined and still in session.
	 * 
	 * @param request
	 * @return
	 */
	public static AppUser getUser(HttpServletRequest request) {
		AppUser appUser = null;
		String token = null;
		HttpSession session = request.getSession(false);
		if (session != null) {
			 token = (String) session.getAttribute(Constants.TOKEN_KEY);
			 if (token != null) {
				 appUser = getUser(token);
			}
		}
		return appUser;
	}
	
	
	
	@SuppressWarnings("rawtypes")
	public static void print() {
		Iterator iter = sharedInstance.loginedUsers.entrySet().iterator(); 
		while (iter.hasNext()) { 
		    Map.Entry entry = (Map.Entry) iter.next(); 
		    String  key =  (String) entry.getKey(); 
		    AppUser val = (AppUser) entry.getValue(); 
		    System.out.println("======== "+key+":"+val.toString());
		} 
	}

}
