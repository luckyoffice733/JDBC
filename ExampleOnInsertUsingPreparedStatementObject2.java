package com.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ExampleOnInsertUsingPreparedStatementObject2 {

	public static void main(String[] args) {
		
		try {
			//load or register the driver for Mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		   //Define the connection URl(Where database is located)
			String url="jdbc:mysql://localhost:3306/training";
			String userName="root";
			String password="root";
			
		  //Establish the connection between the java program and the database(mysql)
			Connection con=DriverManager.getConnection(url, userName, password);
			
		 //insert into employee table using prepared statment
			
		 String queryInsert ="insert into employee values(?,?,?)";
		 
		 //get the preparedStatement object
		  PreparedStatement pstmt= con.prepareStatement(queryInsert);
			
			//initialize the positional parameters with values
		     //using setXXX()
		  
		   pstmt.setInt(1,1020);
		   pstmt.setString(2,"sumit");
		   pstmt.setFloat(3,5000);
			
		//execute the query
		 int iobj= pstmt.executeUpdate();  
		   
			if(iobj>0) {
				System.out.println("Record Inserted Successfully using PreparedStatement");
			}else {
				System.out.println("Record Not Inserted");
			}
			
			
			
			
			pstmt.close();
		  con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}
}
