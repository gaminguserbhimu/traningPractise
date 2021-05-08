package com.crm.vtiger.Tests2;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class TC_12_CreatNewLeadByGivingInvalidInputToAnnualRevenue {
	
	@Test
	public void tc_12_CreatNewLeadByGivingInvalidInputToAnnualRevenue_Test(XmlTest xml) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverUtility wdu = new WebDriverUtility();
				
		//Step 1: Get Url
		driver.get(xml.getParameter("url"));
			
		//Step 2: Login to application
		driver.findElement(By.name("user_name")).sendKeys(xml.getParameter("username"));
		driver.findElement(By.name("user_password")).sendKeys(xml.getParameter("password"));
		driver.findElement(By.id("submitButton")).click();
			
		//Step 3: click on Leads
		driver.findElement(By.linkText("Leads")).click();
		
		//Step 4: create a Lead 
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(xml.getParameter("lastname")+JavaUtility.getRandomData());
		driver.findElement(By.name("company")).sendKeys(xml.getParameter("company")+JavaUtility.getRandomData());
		driver.findElement(By.name("annualrevenue")).sendKeys("Hi"+JavaUtility.getRandomData());
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 5: Condition 
		String expectedAleartText = "Invalid Annual Revenue";
		String actualAleartText = wdu.getAlertText(driver);
		wdu.dismissAlert(driver);
		assertEquals(actualAleartText, expectedAleartText, "FAIL :: New lead is created with invalid annual revenue");
		System.out.println("Pass :: The Lead is not Created due to invalid annual income");
		
		//Step 6: Sign out
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wdu.waitForElementVisibility(driver, element);
		wdu.mouseHover(driver, element);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();	
		
		//Close the Browser
		driver.quit();

	}

}
