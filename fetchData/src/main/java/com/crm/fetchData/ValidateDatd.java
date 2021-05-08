package com.crm.fetchData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ValidateDatd {
	
	@Test
	public void validate() throws Exception {
	Connection conn = null;
		
	try {
		
		//Step 1: Register the database
		Driver driverreff = new Driver();
		DriverManager.registerDriver(driverreff);
		
		 //Step 2: establish Connection with database
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "root");
			
		 //Step 3: Store the values	
		String data = "Varun";
	    List<String> datas = new ArrayList<>();
		
	    //Step 4: Issue create statement
	    Statement stat=conn.createStatement();
		
	    //Step 5: Add all data to list
	    ResultSet result = stat.executeQuery("select * from customer;");
		  while(result.next())  {
			  datas.add(result.getString(1));
			  }
		
		 //Step 6:  Validate the Data
		 for (String string : datas) {
			if (string.equalsIgnoreCase(data)) {
				System.out.println("YES the data is present");
				break;
		 	} 
		  }
		}
		catch (Exception e) {
		}
		finally {
			conn.close();
		}
	}
}
