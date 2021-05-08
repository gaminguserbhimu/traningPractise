package com.crm.vtiger.Tests;

import static org.testng.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.comcast.objectrepositorylib.HomePage;
import com.crm.comcast.objectrepositorylib.LeadsPage;
import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.JavaUtility;

public class TC_14_creatNewLeadByGivingInvalidInputToNoOfEmployee extends BaseClass {
	
	@Test
	public void tc_14_creatNewLeadByGivingInvalidInputToNoOfEmployee_Test() throws Throwable {

		LeadsPage lp = new LeadsPage(driver, wdu);
		(new HomePage(driver, wdu)).leadsPage().createNewLeadWithNoOfEmpeloyes((exu.getExcelData("TC01","TC_14","Leadname")+JavaUtility.getRandomData()) , (exu.getExcelData("TC01","TC_14","company")+JavaUtility.getRandomData()), (exu.getExcelData("TC03","TC_14","NumberOfEmploy")));
		
		//Condition 
		String expectedAleartText = "Invalid No Of Employees";
		String actualAleartText = lp.actualAlertText();
		wdu.dismissAlert(driver);
		assertEquals(actualAleartText, expectedAleartText, "FAIL :: New lead is created with invalid annual revenue");
		Reporter.log("Pass :: The Lead is not Created due to invalid annual income");
				
	}

//	@Test
//	public void createLeadTest() throws Throwable {
//		LeadsPage lp = new LeadsPage(driver, wdu);
//		(new HomePage(driver, wdu)).leadsPage().createNewLeadWithNoOfEmpeloyes((exu.getExcelData("TC01","TC_14","Leadname")+JavaUtility.getRandomData()) , (exu.getExcelData("TC01","TC_14","company")+JavaUtility.getRandomData()), (exu.getExcelData("TC03","TC_14","NumberOfEmploy")));
//		
//		//Condition 
//		String expectedAleartText = "Invalid No Of Employees";
//		String actualAleartText = lp.actualAlertText();
//		wdu.dismissAlert(driver);
//		assertEquals(actualAleartText, expectedAleartText, "FAIL :: New lead is created with invalid annual revenue");
//		System.out.println("Pass :: The Lead is not Created due to invalid annual income");
//				
//	}

}
