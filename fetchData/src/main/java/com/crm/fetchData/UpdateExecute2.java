package com.crm.fetchData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class UpdateExecute2 {
	
	Connection con;
	@Test
	 public void getExecuteQuery() throws SQLException
	 {
		try {
	  //Step 1: Register the database
	  Driver driverref = new Driver();
	  DriverManager.registerDriver(driverref);
	  
	  //Step 2: establish Connection with database
	  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root");
	  
	  //Step 3: Issue create statement
	  Statement stat=con.createStatement();
	  
	  //Step 4: Execute any query
	  ResultSet result = stat.executeQuery("select * from ccustomer;");
	  while(result.next())
	  {
	   System.out.println(result.getString(2));
	  }
	}
		catch (Exception e) {
		}
	  
		finally {
	  //Step 5: Close database connection
			con.close();
			System.out.println("Connection is closed");
		}
	 }


}
