package com.tech.mobile.innovative.dbconnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import java.util.logging.*;





public class dbConnection {
	
	
	private static String url;
	private static String username;
	private static String password;
	private static String driver;
	private static String port;
	private static String dbname;
	private static String separator;
	
	
	Connection connection = null;

	

	public dbConnection()   {
		
		
		
		
		 FileInputStream file = null;
		try {
			file = new FileInputStream("C:\\Users\\shabam\\Desktop\\connection.properties");
			System.out.println("File is located...");
			
		} catch (FileNotFoundException e1) {
			System.out.println("File not located!!!");

			e1.printStackTrace();
		}

		Properties prop = new Properties();

	
		try {
			
			prop.load(file);
			
			System.out.println("Properties file found and loaded...");
		} catch (FileNotFoundException e) {
			System.out.println("Properties file not found, please load!!!");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		username = prop.getProperty("username");
		password = prop.getProperty("password");
		url = prop.getProperty("url");
		driver = prop.getProperty("driver");
		port = prop.getProperty("port");
		dbname = prop.getProperty("dbname");		
		separator = prop.getProperty("separator");
		
		
		//1. Register the driver class
		try {
			Class.forName(driver).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Successfully loaded the driver class...");

		
		//2. Open and Get the JDBC connection
		try {
			System.out.println("Trying to establish connection to " + dbname.toUpperCase() + " database...");
			connection = DriverManager.getConnection(url + port+separator+dbname,username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (connection != null) {
		System.out.println("Successfully connected to the " +  dbname.toUpperCase() + " database...");
		}
		else {
		System.out.println("Connection to the database failed!!!");

		}
	}
	
	
		
	}



