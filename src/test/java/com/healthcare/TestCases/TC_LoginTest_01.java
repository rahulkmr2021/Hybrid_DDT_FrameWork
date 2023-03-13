package com.healthcare.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.healthcare.PageObject.LoginPage;

public class TC_LoginTest_01 extends BaseClass{
	
	
	@Test
	public void hcrLogin() throws InterruptedException, IOException {
		
		
		
		logger.info("URL is Open");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.UserName(user);
		logger.info("Enter UserName");
		
		lp.password01(pwd);
		logger.info("Enter Password");
		
		lp.Login();
		Thread.sleep(5000);
		
		
	if(driver.getCurrentUrl().equals("http://35.92.157.147/firms")) {
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}
		else 
		{
			captureScreen(driver,"TC_LoginTest_01");
			Assert.assertTrue(false);
			logger.info("Login Test Failed"); 
		}   
		
		
		
		
	}
	
	
}
