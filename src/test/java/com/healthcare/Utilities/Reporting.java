package com.healthcare.Utilities;

       /*Listener Class 
        * used to 
        * generate the
        *  Extent Reports
        * 
        */
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter 
{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	public void onStart(ITestContext textcontext) {
		
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());    // time Stamp
		String repName = "Test-Report-"+timestamp+".html";

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+repName); //specify Location
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "F202203001RR-03");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("user", "Rahul_Kmr");

		htmlReporter.config().setDocumentTitle("Health Care Testing Report");  // Title of Report
		htmlReporter.config().setReportName(" Automation Test Report"); //name of Report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);  //location of chart
		htmlReporter.config().setTheme(Theme.DARK);

	}

	public void onTestSuccess(ITestResult tr) 
	
	{
		logger = extent.createTest(tr.getName()); //create new Entry in the Report
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information

		String screenshotPath = System.getProperty("user.dir")+"\\Screenshot\\"+tr.getName()+".png"; 
		File f = new File(screenshotPath);

	}

	public void onTestFailure(ITestResult tr) {

		logger = extent.createTest(tr.getName()); //create new Entry in the Report
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the failed information


		String screenshotPath = System.getProperty("user.dir")+"\\Screenshot\\"+tr.getName()+".png"; 
		File f = new File(screenshotPath);

		if(f.exists())
		{
			try {
				logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
			}
			catch(IOException e) {
				e.printStackTrace();
			}

		}

	}

	public void onTestSkipped(ITestResult tr) {
		logger = extent.createTest(tr.getName()); // create new entry in the Report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));

	}


	public void onFinish(ITestContext testContext) {
		extent.flush();

	}

}
