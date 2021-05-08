package com.crm.vtiger.Tests;

import static org.testng.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.comcast.objectrepositorylib.HomePage;
import com.crm.comcast.objectrepositorylib.LeadsDetailPage;
import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.JavaUtility;

public class TC_11_CreatNewLeadByGivingValidInputToAnnualRevenueTest extends BaseClass {
	
	@Test
	public void tc_11_CreatNewLeadByGivingValidInputToAnnualRevenue_Test() throws Throwable {
		// test
		String lastName = exu.getExcelData("TC01","TC_11","Leadname")+JavaUtility.getRandomData();
		LeadsDetailPage ldp = new LeadsDetailPage(driver, wdu);
		(new HomePage(driver, wdu)).leadsPage().createLeadWithAnnualRevenue((lastName),(exu.getExcelData("TC01","TC_11","company")+JavaUtility.getRandomData()), (exu.getExcelDataInteger("TC01","TC_11","Annual income")+""));

		// Condition 
		boolean actual = ldp.getNewLeadStatus(lastName);
		boolean expected = true;
		assertEquals(actual, expected, "FAIL :: The Lead is not Created");
		Reporter.log("PASS :: New lead is created with unique Lead No",true);
	}
}
