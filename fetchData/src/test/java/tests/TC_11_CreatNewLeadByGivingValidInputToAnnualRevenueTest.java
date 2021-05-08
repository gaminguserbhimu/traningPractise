package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.JavaUtility;

public class TC_11_CreatNewLeadByGivingValidInputToAnnualRevenueTest extends BaseClass {
	
	@Test
	public void tc_11_CreatNewLeadByGivingValidInputToAnnualRevenue_Test() throws Throwable {
			
		// click on Leads
		driver.findElement(By.linkText("Leads")).click();
		
		// create a Lead 
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(exu.getExcelData("TC01","TC_11","Leadname")+JavaUtility.getRandomData());
		driver.findElement(By.name("company")).sendKeys(exu.getExcelData("TC01","TC_11","company")+JavaUtility.getRandomData());
		driver.findElement(By.name("annualrevenue")).sendKeys(exu.getExcelDataInteger("TC01","TC_11","Annual income")+"");
		driver.findElement(By.xpath("//input[@title='Saves [Alt+S]']")).click();
		
		// Condition 
		boolean actual = driver.findElement(By.className("dvHeaderText")).isDisplayed();
		boolean expected = true;
		assertEquals(actual, expected, "FAIL :: The Lead is not Created");
		System.out.println("PASS :: New lead is created with unique Lead No");
	}

}
