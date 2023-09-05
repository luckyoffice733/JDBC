package com.training.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class ExampleOnCallingProcedureWithOutParameterUsingPreparedStatementObject2 {

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
			
		   // calling a procedure addition  with two input parameter and one out parameter
			
			String queryProd = "{call addition(?,?,?) }";
			
			CallableStatement cstmt =con.prepareCall(queryProd);
			//initilazise the input parameter position 1,2
			cstmt.setInt(1,40);
			cstmt.setInt(2,50);
			
			//for out parameter at position 3 we need to register
			cstmt.registerOutParameter(3,Types.INTEGER);
			
			//call the procedure using execute()
			cstmt.execute();
			
			//get the out parameter value using getXXX based on position 3
			int res= cstmt.getInt(3);
			 System.out.println("Sum of two numbers using procedure with out parameter : "+res);
			
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
