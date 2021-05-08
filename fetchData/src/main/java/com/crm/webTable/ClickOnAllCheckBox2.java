package com.crm.webTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClickOnAllCheckBox2 {
	
	@Test
	public void CaptureOrgName() {
		WebDriver driver = new ChromeDriver();
		
		
		//Step 1: Get Url
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Step 2: Login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3: click on organisation
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 4: Click on all check box names
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']//input[@name='selected_id']"));
		for (WebElement webElement : list) {
			webElement.click();
		}
	}

}
