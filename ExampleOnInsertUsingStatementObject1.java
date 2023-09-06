package com.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExampleOnInsertUsingStatementObject1 {

	public static void main(String[] args) {
		
		try {
			
		
		  Connection con= DBUtills.getJdbcMySqlConn();
		   Statement stmt= con.createStatement();
		   
		  String  queryInsert="insert into employee values(1016,'Allen',7000)";
		   
		  int iobj= stmt.executeUpdate(queryInsert);
		  
		  if(iobj > 0) {
			  System.out.println("Record Is Successfully Inserted ");
			  
		  }else {
			  System.out.println("Record is not Inserted");
		  }
		  
		  //close all the object
		  stmt.close();
		  con.close();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}
}
