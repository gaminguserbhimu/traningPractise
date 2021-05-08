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
public class LeadsPage extends BasePage {

	public LeadsPage(WebDriver driver, WebDriverUtility webDriverUtility) {
		super(driver, webDriverUtility);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (xpath = "//img[@title='Create Lead...']")
	private WebElement createLeadButton;
	
	@FindBy (name = "lastname")
	private WebElement lastNameTF;
	
	@FindBy (name = "company")
	private WebElement companyTF;
	
	@FindBy (name = "annualrevenue")
	private WebElement annualRevenueTF;
	
	@FindBy (name = "noofemployees")
	private WebElement noOfEmployeesTF;
	
	@FindBy (name = "email")
	private WebElement PrimaryEmailTF;
	
	@FindBy (name = "secondaryemail")
	private WebElement SecondaryEmailTF;
	
	@FindBy (xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getCreateLeadButton() {
		return createLeadButton;
	}

	public WebElement getLastNameTF() {
		return lastNameTF;
	}

	public WebElement getCompanyTF() {
		return companyTF;
	}

	public WebElement getAnnualRevenueTF() {
		return annualRevenueTF;
	}

	public WebElement getNoOfEmployeesTF() {
		return noOfEmployeesTF;
	}

	public WebElement getPrimaryEmailTF() {
		return PrimaryEmailTF;
	}

	public WebElement getSecondaryEmailTF() {
		return SecondaryEmailTF;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/**
	 * Create a new Lead with Annual Revenue
	 * @param lastname
	 * @param company
	 * @param annualRevenue
	 */
	public void createLeadWithAnnualRevenue(String lastname,String company,String annualRevenue) {
		getCreateLeadButton().click();
		getLastNameTF().sendKeys(lastname);
		getCompanyTF().sendKeys(company);
		getAnnualRevenueTF().sendKeys(annualRevenue);
		getSaveButton().click();
	}
	/**
	 * Create a new Lead with No Of Employees
	 * @param lastname
	 * @param company
	 * @param noOfEmployee
	 */
	public void createNewLeadWithNoOfEmpeloyes(String lastname,String company,String noOfEmployee) {
		getCreateLeadButton().click();
		getLastNameTF().sendKeys(lastname);
		getCompanyTF().sendKeys(company);
		getNoOfEmployeesTF().sendKeys(noOfEmployee);
		getSaveButton().click();
	}
	/**
	 * Create a new Lead with primary email and secondary email
	 * @param lastname
	 * @param company
	 * @param primaryEmail
	 * @param secondaryEmail
	 */
	public void createNewLeadWithEmail(String lastname,String company,String primaryEmail,String secondaryEmail) {
		getCreateLeadButton().click();
		getLastNameTF().sendKeys(lastname);
		getCompanyTF().sendKeys(company);
		getPrimaryEmailTF().sendKeys(primaryEmail);
		getSecondaryEmailTF().sendKeys(secondaryEmail);
		getSaveButton().click();
	}
	/**
	 * Get actual Alert text
	 * @return
	 */
	public String actualAlertText() {
		return webDriverUtility.getAlertText(driver);
	}
}
