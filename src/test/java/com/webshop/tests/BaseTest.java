package com.webshop.tests;


import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.webshop.base.DriverScript;
import com.webshop.pages.HomePage;
import com.webshop.pages.LoginPage;
import com.webshop.utils.ExcelUtil;
import com.webshop.utils.HelperUtil;

public class BaseTest extends DriverScript {
	
	protected static ExtentHtmlReporter extent;
	protected static ExtentReports report;
	protected static ExtentTest logger;
	HomePage homePage;
	LoginPage loginPage;
	
	@BeforeSuite
	public void setUpReport() 
	{
		extent = new ExtentHtmlReporter("./reports/index_"+System.currentTimeMillis()+".html");
		report = new ExtentReports();
		report.attachReporter(extent);	
	}
	
	@BeforeMethod
	public void setUp() {
		initApplication();
		homePage = new HomePage();
		loginPage = new LoginPage();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			try 
			{
				logger.fail("test-failed",
				MediaEntityBuilder.createScreenCaptureFromPath(HelperUtil.captureScreen(driver)).build());
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		report.flush();
		quitDriver();
	}
	
	@DataProvider(name="wsdata")
	public Object[][] testData()
	{
		ExcelUtil excel = new ExcelUtil("./src/test/resources/testdata/wsdata.xlsx");
		int rows = excel.getRowCount(0);
		
		Object data[][] = new Object[rows][2];
		
		for(int i=0; i<rows; i++)
		{
			data[i][0] = excel.getCellData(0, i, 0);
			data[i][1] = excel.getCellData(0, i, 1);
		}
		
		return data;
	}

}








