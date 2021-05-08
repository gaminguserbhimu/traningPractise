package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

/**
 * 
 * @author vinay
 *
 */
public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver, WebDriverUtility webDriverUtility) {
		super(driver, webDriverUtility);
	}

	@FindBy (name = "user_name")
	private WebElement usernameTF;
	
	@FindBy (name = "user_password")
	private WebElement passwordTF;
	
	@FindBy (id = "submitButton")
	private WebElement submitButton;

	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	/**
	 * Log in to application
	 * @param url
	 * @param username
	 * @param password
	 * @return
	 */
	public HomePage Login(String url,String username,String password) {
		driver.get(url);
		getUsernameTF().sendKeys(username);
		getPasswordTF().sendKeys(password);
		getSubmitButton().click();
		return new HomePage(driver, webDriverUtility);
	}

}
