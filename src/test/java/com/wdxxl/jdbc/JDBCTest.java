package com.wdxxl.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTest {
	
	public static void main(String[]args) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Class.forName("org.postgresql.Driver").newInstance();
		try {
			Properties props = new Properties();
            props.put("user", "postgres");
            props.put("password", "B!n71jk1");

			Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/webapp", props);
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
