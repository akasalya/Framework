package com.learnautomation.testcases;


import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utility.Helper;

public class LoginTestCRM extends BaseClass
{
	
    @Test
	public void loginApp()
	{

    	logger=report.createTest("Login to CRM");

		//System.out.println(driver.getTitle());

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Application");

		loginPage.loginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		logger.pass("Login Success");

         Helper.captureScreenShot(driver);

	}

	
}
//abstraction->>Showing  the essinital feature & hiding the background details.