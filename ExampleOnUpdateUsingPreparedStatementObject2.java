package com.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ExampleOnUpdateUsingPreparedStatementObject2 {

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
			
		 //update employee record empno 1020 ,update ename smith to smith joe and sal 5000 to 6000
		
			String queryUpdate = "update employee set ename=?,sal=? where empno=?";
			
			PreparedStatement pstmt = con.prepareStatement(queryUpdate);
			pstmt.setString(1,"smith joe");
			pstmt.setFloat(2,6000);
			pstmt.setInt(3,1020);
			
		 int iobj= pstmt.executeUpdate();  
		   
			if(iobj>0) {
				System.out.println("Record Updated Successfully using PreparedStatement");
			}else {
				System.out.println("Record Not Yet Updated");
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
