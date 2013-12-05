package com.wdxxl.form;

public class User {
	private String name;
	private Long age;
	private String description;
	private String password;
	private String times;
	
	public User() {
		super();
	}

	public User(String name, Long age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return this.name+this.age+this.description+this.password+this.times;
	}
	
	
}
