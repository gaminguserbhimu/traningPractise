package com.crm.VtigerTests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateContactandOrganistion {
	
	@Test
	public void createContactandOrg() throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
		
		
		//Step 1: Get Url
		driver.get("http://localhost:8888");
		
		//Step 2: Login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3: click on organisation
		driver.findElement(By.linkText("Organizations")).click();
				
		//Step 4: create Organisation
		String organisationName = "TYSS08";
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(organisationName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(5000);
		
		//Step 3: click to Contacts
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 4: create contact
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("VarunKumar");
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		Thread.sleep(5000);
		String defaultwin = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		
		for (String string : windows) {
			driver.switchTo().window(string);
		}
		
		driver.findElement(By.linkText(organisationName)).click();
		driver.switchTo().window(defaultwin);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();		
		Thread.sleep(5000);

		//Step 5: Sign out
		actions.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
