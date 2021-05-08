package com.crm.vtiger.Tests2;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.crm.vtiger.GenericUtils.JavaUtility;

public class TC_11_CreatNewLeadByGivingValidInputToAnnualRevenueTest extends BaseClass {
	
	@Test
	public void tc_11_CreatNewLeadByGivingValidInputToAnnualRevenue_Test(XmlTest xml) throws Throwable {
		
			
		//Step 3: click on Leads
		driver.findElement(By.linkText("Leads")).click();
		
		//Step 4: create a Lead 
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(xml.getParameter("lastname")+JavaUtility.getRandomData());
		driver.findElement(By.name("company")).sendKeys(xml.getParameter("company")+JavaUtility.getRandomData());
		driver.findElement(By.name("annualrevenue")).sendKeys(""+JavaUtility.getRandomData());
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 5: Condition 
		boolean actual = driver.findElement(By.className("dvHeaderText")).isDisplayed();
		boolean expected = true;
		assertEquals(actual, expected, "FAIL :: The Lead is not Created");
		System.out.println("PASS :: New lead is created with unique Lead No");
				
	}

}
