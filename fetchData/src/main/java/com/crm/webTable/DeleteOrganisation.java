package com.crm.webTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DeleteOrganisation {
	
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
		
		String data = "TYSS03";
		boolean flag = false;
		//Step 4: Click on all check box names
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']//a[@title='Organizations']"));
		for (WebElement webElement : list) {
			if (webElement.getText().equalsIgnoreCase(data)) {
			webElement.click();
			flag = true;
			driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
			driver.switchTo().alert().accept();
			break;
			}
		}
		
		
		driver.quit();
		if (flag) {
			System.out.println("The Opton is deleted");
		} else {
			System.out.println("THe Option is not Present");
		}
		
	}

}
