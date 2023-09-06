package com.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtills {

	  public static Connection getJdbcMySqlConn() {
		  
		  Connection con=null;
		    //load or register the driver for Mysql
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//Define the connection URl(Where database is located)
				String url="jdbc:mysql://localhost:3306/training";
				String userName="root";
				String password="root";
				
	     //Establish the connection between the java program and the database(mysql)
		   con=DriverManager.getConnection(url, userName, password);
		  
		
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   	
			  return con;
		  
	  }
	
	
	
}
