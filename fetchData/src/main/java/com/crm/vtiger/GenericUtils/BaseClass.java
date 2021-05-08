package com.crm.vtiger.GenericUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.comcast.objectrepositorylib.HomePage;
import com.crm.comcast.objectrepositorylib.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public FileUtility file = new FileUtility();
	public ExcelUtility exu = new ExcelUtility();
	public WebDriverUtility wdu = new WebDriverUtility();
	public static WebDriver sdriver;
	
	@BeforeSuite
	public void configsBS() {
		//Connect to DataBase
	}
	
	@BeforeTest
	public void configBT() {
		//Launch browser in parallel mode
	}
	
	
//	@Parameters("browser")
	@BeforeClass
	public void configBC() throws Throwable {
		String browserName =file.getDatafromJason("browser");
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
	public void setUp() throws Throwable {
		LoginPage lp = new LoginPage(driver, wdu);
		lp.Login(file.getDatafromJason("url"), file.getDatafromJason("username"), file.getDatafromJason("password"));
	}
	
	@AfterMethod
	public void signOut() {
		HomePage hp = new HomePage(driver, wdu);
		hp.signOut();
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
