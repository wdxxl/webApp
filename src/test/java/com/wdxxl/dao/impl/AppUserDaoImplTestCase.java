package com.wdxxl.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wdxxl.dao.IAppUserDao;
import com.wdxxl.domain.AppUser;
import com.wdxxl.test.util.SpringTransactionalTestCase;

public class AppUserDaoImplTestCase extends SpringTransactionalTestCase {
	@Autowired
	public IAppUserDao AppUserDao;
	
	@Test
	public void testGetAppUserByLoginName(){
		AppUser appUser = AppUserDao.getAppUserByLoginName("kwang");
		System.out.println(appUser.getPassword());
	}
	
	@Test
	public void testGetAppUserList(){
		List<AppUser> appUserList = AppUserDao.getAppUserList();
		System.out.println(appUserList.size());
	}
	
	@Test
	public void testJDBC(){
		try {
			Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select count(*) from app_user ");
			while(rs.next()){
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
