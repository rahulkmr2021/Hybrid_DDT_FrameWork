package com.healthcare.TestCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.healthcare.PageObject.LoginPage;
import com.healthcare.Utilities.XlUtils;

public class TC_LoginTEST_DDT_001  extends BaseClass

{
	@Test(dataProvider="TestData")
	public void loginDDT(String user,String pwd) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.UserName(user);
		Thread.sleep(3000);
		logger.info("Enter UserName");
		lp.password01(pwd);
		Thread.sleep(3000);
		logger.info("Enter Password");
		lp.Login();
		Thread.sleep(3000);
		
	}
	@DataProvider(name="TestData")
	String[][] getData() throws IOException{
		
		String path =System.getProperty("user.dir")+ "/src/test/java/com/healthcare/TestData/TestData.xlsx" ;
		
		int rownum = XlUtils.getRowCount(path, "Sheet1");
		int colcount =XlUtils.getCellCount(path, "Sheet1",1);
		
		String testdata[][] = new String[rownum][colcount];
		
		for(int i=1;i<rownum;i++) 
		{
			for(int j=0;j<colcount;j++)
			{
				testdata[i-1][j]=XlUtils.getCellData(path, "Sheet1",i, j); // 1 0
			}
		}
		return testdata;
		
	}
	
	

}
