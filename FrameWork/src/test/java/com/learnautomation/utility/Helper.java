package com.learnautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {


	//Screenxhot,alert,frame,window,Syc issue,javascript executer

	public static String captureScreenShot(WebDriver driver)
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath=System.getProperty("user.dir")+"./Screenshorts/_"+getcurrentDateTime()+".png";

		try {
			FileHandler.copy(src, new File(screenshotPath));

			System.out.println("screenshort captured");
		} catch (IOException e) {

			System.out.println("unable to capture screenshort"+e.getMessage());
		}
		return screenshotPath;
	}

	public static String getcurrentDateTime()
	{
		DateFormat customFormat=new SimpleDateFormat("MM_dd-yyyy_HH_mm_ss");

		Date currentDate=new Date();

		return customFormat.format(currentDate);
	}

	public void handle()
	{

	}
}
