package com.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ExampleOnDeleteUsingPreparedStatementObject1 {

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
			
		 //delete the record where empno=1001
		
			String queryDel = "delete from employee where empno=?";
			
			PreparedStatement pstmt = con.prepareStatement(queryDel);
			pstmt.setInt(1,1001);
	
			
		 int iobj= pstmt.executeUpdate();  
		   
			if(iobj>0) {
				System.out.println("Record Deleted Successfully using PreparedStatement");
			}else {
				System.out.println("Record Not Yet Deleted");
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
