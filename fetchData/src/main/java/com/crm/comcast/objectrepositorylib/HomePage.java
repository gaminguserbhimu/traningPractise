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
public class HomePage extends BasePage {

	public HomePage(WebDriver driver, WebDriverUtility webDriverUtility) {
		super(driver, webDriverUtility);
	}
	
	@FindBy (xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement userlink;
	
	@FindBy (xpath = "//a[text()='Sign Out']")
	private WebElement signOutButton;
	
	@FindBy (linkText = "Leads")
	private WebElement LeadsButton;

	public WebElement getUserlink() {
		return userlink;
	}

	public WebElement getSignOutButton() {
		return signOutButton;
	}

	public WebElement getLeadsButton() {
		return LeadsButton;
	}
	
	public LeadsPage leadsPage() {
		
		getLeadsButton().click();
		return new LeadsPage(driver, webDriverUtility);
	}
	
	/**
	 * Use this to sign out from application
	 */
	public void signOut() {
		webDriverUtility.waitForElementVisibility(driver, getUserlink());
		webDriverUtility.mouseHover(driver, getUserlink());
		getSignOutButton().click();
	}

}
