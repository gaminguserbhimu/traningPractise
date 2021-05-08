package com.crm.fetchData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtils {
	@Test
	 public void getExecuteQuery() throws SQLException
	 {
	  //Step 1: Register the database
	  Driver driverref = new Driver();
	  DriverManager.registerDriver(driverref);
	  
	  //Step 2: establish Connection with database
	  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root");
	  
	  //Step 3: Issue create statement
	  Statement stat=con.createStatement();
	  
	  //Step 4: Execute any query
	  int result = stat.executeUpdate("insert into customer VALUES('SURAJ KUMAR2', 'Tom B. Fransis', 'Las Santos', 'busystreet', '5014', 'LasVegas');");
	  if (result == 1) {
		System.out.println("The condition is satisfied");
	  } else {
		System.out.println("The querry failed");
	  }
	  
	  //Step 5: Close database connection
	  con.close();
	 }


}
