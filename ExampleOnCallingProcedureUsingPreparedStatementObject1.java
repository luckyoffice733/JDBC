package com.training.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExampleOnCallingProcedureUsingPreparedStatementObject1 {

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
			
		   // calling a procedure getEmpDetails(in) with one input parameter
			
			String queryProd = "{call getEmpDetails(?)}";
			
			CallableStatement cstmt =con.prepareCall(queryProd);
			//initilazise the input parameter
			
			cstmt.setInt(1,10);
			
			//to calll the procedure
		    //	cstmt.execute() or cstmt.executeQuery();
			
			ResultSet rs=cstmt.executeQuery();
			
			System.out.println("Calling Procedure its will display the employee data based on deptno");
			
			while(rs.next()) {
				System.out.println(rs.getInt("empno")+" "+rs.getString("ename")+" "+rs.getFloat("sal"));
			}
			
			rs.close();
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
