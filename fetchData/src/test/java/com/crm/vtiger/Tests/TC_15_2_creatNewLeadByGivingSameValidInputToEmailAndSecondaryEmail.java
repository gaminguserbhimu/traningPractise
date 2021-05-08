package com.crm.vtiger.Tests;

import static org.testng.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.comcast.objectrepositorylib.HomePage;
import com.crm.comcast.objectrepositorylib.LeadsDetailPage;
import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.JavaUtility;

public class TC_15_2_creatNewLeadByGivingSameValidInputToEmailAndSecondaryEmail extends BaseClass {
	
	@Test
	public void tc_15_2_creatNewLeadByGivingSameValidInputToEmailAndSecondaryEmail_Test() throws Throwable {
		
		String lastName = exu.getExcelData("TC01","TC_15","Leadname")+JavaUtility.getRandomData();
		LeadsDetailPage ldp = new LeadsDetailPage(driver, wdu);
		(new HomePage(driver, wdu)).leadsPage().createNewLeadWithEmail(lastName , (exu.getExcelData("TC01","TC_15","company")+JavaUtility.getRandomData()), (exu.getExcelData("TC01","TC_15","Email")), (exu.getExcelData("TC01","TC_15","Email")));

		//Condition 
		boolean actual = ldp.getNewLeadStatus(lastName);
		boolean expected = true;
		assertEquals(actual, expected, "FAIL :: New lead is created with same EMAIL ID");
		Reporter.log("PASS :: The Lead is not Created");
	}

}
