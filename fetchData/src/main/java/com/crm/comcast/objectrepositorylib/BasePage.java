package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

	/**
	 * 
	 * @author vinay
	 *
	 */
public class BasePage {
	
	WebDriver driver;
	WebDriverUtility webDriverUtility;
	
	/**
	 * you can import all webDriver Elements from here
	 * @param driver
	 * @param webDriverUtility
	 */
	public BasePage(WebDriver driver, WebDriverUtility webDriverUtility) {
		super();
		this.driver = driver;
		this.webDriverUtility = webDriverUtility;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * 
	 * @param expectedTitle
	 * @return
	 */

	public boolean verifyTitle(String expectedTitle) {
		return driver.getTitle().equalsIgnoreCase(expectedTitle);
	}
	
	/**
	 * Verify Current Url
	 * @param expectedUrl
	 * @return
	 */
	public boolean verifyCurrentUrl(String expectedUrl) {
		return driver.getCurrentUrl().equalsIgnoreCase(expectedUrl);
	}

}
