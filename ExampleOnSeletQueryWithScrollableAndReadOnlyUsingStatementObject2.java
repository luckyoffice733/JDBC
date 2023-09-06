
package com.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExampleOnSeletQueryWithScrollableAndReadOnlyUsingStatementObject2 {

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
		   Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
		   String empRecords = "select * from employee";
			
		   ResultSet rs =stmt.executeQuery(empRecords);
		   //System.out.println(rs);
		   System.out.println("Employee Records are in Forward direction:");
		   
		   while(rs.next()) {
			   System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
		   }
		  
            System.out.println("Employee Records are in Backward direction:");
		   
		   while(rs.previous()) {
			   System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
		   }
		   
		   System.out.println("+++++++++++");
			rs.first();
			System.out.println("First Record ");
			 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
		   
			   System.out.println("+++++++++++");
				rs.last();
				System.out.println("Last Record ");
				 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
				 
				 System.out.println("+++++++++++");
					rs.absolute(2); //random
					System.out.println("random record ");
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
				 
				 
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
