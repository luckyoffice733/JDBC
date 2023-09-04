package com.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExampleOnDeleteUsingStatementObject1 {

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
			
		  //Get the Statement Object to execute the execute the queries.
			
		   Statement stmt= con.createStatement();
		   
		  //delete the record where empno=1012 ;
		   
		   String queryDel="delete from employee where empno=1012 ";
		   
		   int iobj = stmt.executeUpdate(queryDel); //based on query no of record effected it will return
		   
		   if(iobj>0) {
			   System.out.println("Record Deleted SuccessFully");
		   }else {
			   System.out.println("Record Not Yet Deleted");
		   }
		  
		  //close all the object
		  stmt.close();
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
