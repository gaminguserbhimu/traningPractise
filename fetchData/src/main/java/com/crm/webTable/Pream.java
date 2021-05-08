package com.crm.webTable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class Pream {
	
	@Test
	public void convertLeadtoOpportunity() throws Throwable
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverUtility wdu = new WebDriverUtility();
		
		//Step 1: Get Url
		driver.get("http://localhost:8888");
			
		//Step 2: Login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
			
		//Step 3: click on Lead
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//a[@title='Leads']")).click();
		driver.findElement(By.linkText("Convert Lead")).click();
		driver.findElement(By.xpath("//b[.='Opportunity']/../input")).click();
		wdu.waitAndClick(driver.findElement(By.id("jscal_trigger_closedate")));
		driver.findElement(By.xpath("//td[.='1']")).click();
		
		
		
	}

}
