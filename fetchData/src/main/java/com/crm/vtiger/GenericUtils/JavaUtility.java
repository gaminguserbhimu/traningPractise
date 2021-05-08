package com.crm.vtiger.GenericUtils;

import java.util.Date;
import java.util.Random;

/**
 * This class contains java specific generic Libraries
 * @author vinay
 *
 */

public class JavaUtility {
	
	/**
	 * generate random number
	 * @Vinay
	 * 
	 */
	public static int getRandomData() {
		Random random = new Random();
		int ran = random.nextInt(1000);
		return ran;
	}
	
	/**
	 * generate current system date
	 * @Vinay
	 * 
	 */
	public String getCurrentSystemDate() {
		Date date = new Date();
		String currentDate = date.toString();
		return currentDate;
	}

}
