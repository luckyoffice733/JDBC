package com.training.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class ExampleOnCallingFunctionUsingCallableStatementObject1 {

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
		
			
		  // calling a function fun_addition(int,int,int) 
			
			String queryFun = "{? = call fun_addition (?,?,?)}";
			
			CallableStatement cstmt = con.prepareCall(queryFun);
			
			//registering the return type position
			cstmt.registerOutParameter(1,Types.INTEGER);
			
			//initialize the fun_addition() parameters
			cstmt.setInt(2,10);
			cstmt.setInt(3,30);
			cstmt.setInt(4,60);
			
			//execute the function by calling execute()	
			cstmt.execute();
			
			//get the return value from the registerOutParameter position at 1
			int sum=cstmt.getInt(1);
			System.out.println("Calling a function and it return the value is : "+sum);
		 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}
}
