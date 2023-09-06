
package com.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExampleOnSeletQueryWithScrollableAndUpdatableUsingStatementObject3 {

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
		
		//making ResultSet Scrollable and updatable 
		   Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
		   String empRecords = "select * from d_dept";
			
		   ResultSet rs =stmt.executeQuery(empRecords);
		   //System.out.println(rs);
		   System.out.println("Department Records are in Forward direction:");
		   
		   while(rs.next()) {
			   System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		   }
		  
            System.out.println("Department Records Records are in Backward direction:");
		   
		   while(rs.previous()) {
			   System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		   }
		   
		   System.out.println("+++++++++++");
			rs.first();
			System.out.println("First Record ");
			  System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		   
			   System.out.println("+++++++++++");
				rs.last();
				System.out.println("Last Record ");
				  System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)); 
				  
				  
				  
				   //insert a record into d_dept table using Updatable ResultSet
				   
					/*
					 * rs.moveToInsertRow(); rs.updateInt("deptno", 60);
					 * rs.updateString("dname","testing"); rs.updateString("loc","HYD");
					 * 
					 * rs.insertRow();
					 * 
					 * System.out.println("Record inserted using Updatable ResultSet");
					 */
			   
				//udpate the record in d_dept table using  updatable resultset
				  //place the cursor on which record to udpate using rs.absolute(rowno)
				   //update 30 record where change dname SALES-->Devops and Chicage ==> MUMBAI
				  
				  
				/*
				 * rs.absolute(3); rs.updateString("dname","DevOps");
				 * rs.updateString("loc","mumbai");
				 * 
				 * rs.updateRow();
				 * 
				 * System.out.println("Rcord is update on d_dept");
				 */
					 
				//first place a cursor on which record to delete  using rs.absolute(rowno)
					// delete a record from d_dept where deptno=40
					   
					   rs.absolute(4);
					   rs.deleteRow();	  
			     System.out.println("Record is deleted ");
			
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
