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
public class LeadsDetailPage extends BasePage {

	public LeadsDetailPage(WebDriver driver, WebDriverUtility webDriverUtility) {
		super(driver, webDriverUtility);
	}
	
	@FindBy(className = "dvHeaderText")
	private WebElement leadsNameText;

	public WebElement getLeadsNameText() {
		return leadsNameText;
	}
	
	/**
	 * Verify weather the lead is created or not
	 * @param lastname
	 * @return
	 */
	
	public boolean getNewLeadStatus(String lastname) {
		return getLeadsNameText().getText().contains(lastname);
	}
	
	

}
