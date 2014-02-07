package com.wdxxl.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the "APP_USER" database table.
 * 
 */
@Entity
@Table(name="\"app_user\"")
public class AppUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="app_user_id")
	private Integer appUserId;

	@Column(name="login_name")
	private String loginName;

	private String password;

	public AppUser() {
	}

	public AppUser(String loginName, String password) {
		super();
		this.loginName = loginName;
		this.password = password;
	}


	public Integer getAppUserId() {
		return this.appUserId;
	}

	public void setAppUserId(Integer appUserId) {
		this.appUserId = appUserId;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}