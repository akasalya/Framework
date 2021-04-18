package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{
    WebDriver driver;
    
    //in this page we r creating constructer
	public  LoginPage(WebDriver ldriver) 
	{
		this.driver=ldriver;
	}
	
	@FindBy(name="email1") WebElement uname;
	
	@FindBy(name="pass") WebElement password;
	
	@FindBy(name="login") WebElement loginButton;
	
	public void loginToCRM(String usernameApplication,String passwordApplication)
	{
		try 
		{
			Thread.sleep(2000);
		}catch(InterruptedException e)
		{
			
		}
		uname.sendKeys(usernameApplication);
		password.sendKeys(passwordApplication);
		loginButton.click();
		
		
	}

}
