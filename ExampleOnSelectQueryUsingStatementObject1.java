
package com.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExampleOnSelectQueryUsingStatementObject1 {

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
		
		//select * from employee
		   Statement stmt=con.createStatement();
			
		   String empRecords = "select * from employee";
			
		   ResultSet rs =stmt.executeQuery(empRecords);
		   System.out.println(rs);
		   System.out.println("Employee Records are :");
		   
		   while(rs.next()) {
			   System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
		   }
		   
		   rs.close();
		   stmt.close();
		   
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
