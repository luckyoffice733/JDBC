package com.training.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class ExampleOnCallingFunctionUsingCallableStatementObject2 {

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
			
			String queryFun = "{? = call getDeptName(?)}";
			
			CallableStatement cstmt = con.prepareCall(queryFun);
			
			//register the out parameter
			cstmt.registerOutParameter(1,Types.VARCHAR);
			cstmt.setInt(2,20);
			
			//call the function
			cstmt.execute();
			
			//get the return value from registerOutParameter at position 1
			String deptName =cstmt.getString(1);
			
			System.out.println("DeptName Based on DeptNO 20: "+deptName);
			
			cstmt.close();
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}
}
