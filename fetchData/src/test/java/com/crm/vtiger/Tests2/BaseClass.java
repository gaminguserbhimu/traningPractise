package com.crm.vtiger.Tests2;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.xml.XmlTest;

import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class BaseClass {
	public WebDriver driver;
	public FileUtility file = new FileUtility();
	public ExcelUtility exu = new ExcelUtility();
	public WebDriverUtility wdu = new WebDriverUtility();
	
	@BeforeSuite
	public void configsBS() {
		//Connect to DataBase
	}
	
	@BeforeTest
	public void configBT() {
		//Launch browser in parallel mode
	}
	
	@BeforeClass
	public void configBC(XmlTest xml) {
		String browserName = xml.getParameter("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if(browserName.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("Browser is not supported");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void setUp(XmlTest xml) {
		driver.get(xml.getParameter("url"));
		driver.findElement(By.name("user_name")).sendKeys(xml.getParameter("username"));
		driver.findElement(By.name("user_password")).sendKeys(xml.getParameter("password"));
		driver.findElement(By.id("submitButton")).click();
	}
	
	@AfterMethod
	public void signOut() {
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wdu.waitForElementVisibility(driver, element);
		wdu.mouseHover(driver, element);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
	@AfterClass
	public void config() {
		driver.quit();
	}
	
	@AfterTest
	public void configAT() {
		//Close browser in parallel mode
	}
	
	@AfterSuite
	public void configsAS() {
		//Disconnect to DataBase
	}


}
