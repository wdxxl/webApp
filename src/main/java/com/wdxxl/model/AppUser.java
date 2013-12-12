package com.wdxxl.model;

/**
 * Login User 
 * 
 * @author 
 *
 */
public class AppUser {
	private String loginName;
	private String password;
	
	public AppUser() {
		super();
	}
	
	public AppUser(String loginName, String password) {
		super();
		this.loginName = loginName;
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	@Override
	public String toString() {
		return "AppUser [loginName=" + loginName + ", password=" + password
				+ "]";
	}
}
