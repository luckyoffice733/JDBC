package com.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExampleOnUpdateUsingStatementObject1 {

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
		   
		   //update the record empno 1015 update ename martin to martin stev and sal 6000 to 8000
		   
		   String queryUpate="update employee set ename='martinstev', sal=8000 where empno=1015";
		   
		   int iobj = stmt.executeUpdate(queryUpate);
		   
		   if(iobj>0) {
			   System.out.println("Record Updated SuccessFully");
		   }else {
			   System.out.println("Record Not Yet Updated'");
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
