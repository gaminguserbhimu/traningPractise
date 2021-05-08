package com.crm.vtiger.Tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.crm.comcast.objectrepositorylib.HomePage;
import com.crm.comcast.objectrepositorylib.LeadsPage;
import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.JavaUtility;

public class TC_12_CreatNewLeadByGivingInvalidInputToAnnualRevenue extends BaseClass {
	
	@Test
	public void tc_12_CreatNewLeadByGivingInvalidInputToAnnualRevenue_Test() throws Throwable {
		
		LeadsPage lp = new LeadsPage(driver, wdu);
		(new HomePage(driver, wdu)).leadsPage().createLeadWithAnnualRevenue((exu.getExcelData("TC01","TC_12","Leadname")+JavaUtility.getRandomData()),
																				(exu.getExcelData("TC01","TC_12","company")+JavaUtility.getRandomData()), (exu.getExcelData("TC01","TC_12","Annual income")));
		// Condition 
		String expectedAleartText = "Invalid Annual Revenue";
		String actualAleartText = lp.actualAlertText();
		wdu.dismissAlert(driver);
		assertEquals(actualAleartText, expectedAleartText, "FAIL :: New lead is created with invalid annual revenue");
		System.out.println("Pass :: The Lead is not Created due to invalid annual income");

	}

}
