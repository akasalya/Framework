package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
    public ExtentTest logger;
    
	@BeforeSuite
	public void setUpSuit()
	{
		Reporter.log("Setting up reports and Test is getting ready",true);
		
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();

		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM_"+Helper.getcurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting Done Testcan be Started",true);
	}

	@BeforeClass
	public void setup()
	{
		Reporter.log("Trying to start Browser and Application Ready",true);
		driver=BrowserFactory.startApplication(driver, config.getBrowser(),config.getStringURL());
		
		Reporter.log("Browser and Application up and running",true);

	}

	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);

	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		Reporter.log("Test is about to end",true);
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Helper.captureScreenShot(driver);
			logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			logger.pass("Test passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		report.flush();
		
		Reporter.log("Test Completed>>>Reports genratred",true);
	}
	
	



}
