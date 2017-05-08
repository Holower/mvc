package com.mvc.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {

	public static Connection createConnection()
	{
		Connection con = null;
		
		Properties properties = new Properties();
		try{
			System.out.println(Thread.currentThread().getContextClassLoader().toString());
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		String url = properties.getProperty("jdbc.url");
		String driver = properties.getProperty("jdbc.driver");
		String username = properties.getProperty("jdbc.username");
		String password = properties.getProperty("jdbc.password");
		System.out.println(driver);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		/*
		String url = "jdbc:mysql://localhost:3306/sitio"; //for SQL and oracle or any other db server this url differs. where ravi is the database name and 3306 is the port where mysql is running
		String username = "root"; //username of database user
		String password = ""; //password
		*/
		try {
			try {
			Class.forName(driver);// differs from DB server to server
			}
			catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
			
			con = DriverManager.getConnection(url, username, password);
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static Connection getInstance()
	{
		return createConnection();
	}
	
	
}
