package com.crm.webTable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ClearTripCalender {
	
	@Test
	public void calender() {
		
		WebDriver driver = new ChromeDriver();
		
		
		//Step 1: Get Url
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
		actions.moveByOffset(80, 80).click().perform();

		//Step 2: enter details
		driver.findElement(By.id("fromCity")).sendKeys("NewYork");
		driver.findElement(By.xpath("//li[contains(@id,'react-autowhatever')]")).click();
		driver.findElement(By.id("toCity")).sendKeys("London");
		driver.findElement(By.xpath("//li[contains(@id,'react-autowhatever')]")).click();
		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
	
	}

}
