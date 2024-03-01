package com.ws.tests;

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
import com.ws.base.DriverScript;
import com.ws.pages.BooksPage;
import com.ws.pages.ComputersPage;
import com.ws.pages.HomePage;
import com.ws.pages.LoginPage;
import com.ws.utils.ExcelUtil;
import com.ws.utils.Helper;

public class BaseTest extends DriverScript {
	
	protected static ExtentReports report;
	protected static ExtentTest logger;
	HomePage homePage;
	LoginPage loginPage;
	BooksPage booksPage;
	ComputersPage computersPage;
	
	@BeforeSuite
	public void setUpReport() 
	{
		ExtentHtmlReporter extent = new ExtentHtmlReporter("./reports/wsreport"+System.currentTimeMillis()+".html");
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeMethod
	public void setUp()
	{
		initApplication();
		homePage = new HomePage();
		loginPage = new LoginPage();
		booksPage = new BooksPage();
		computersPage = new ComputersPage();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			try {
				logger.fail("Test Failed",
						MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreen(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		report.flush();
		quitDriver();
	}
	
	@DataProvider(name="wsdata")
	public Object[][] testData()
	{
		ExcelUtil xl = new ExcelUtil("./src/test/resources/testdata/wsdata.xlsx");
		int rows = xl.getRowCount(0);
		
		Object[][] data = new Object[rows][2];
		
		for(int i=0; i<rows; i++)
		{
			data[i][0]=xl.getCellData(0, i, 0);
			data[i][1]=xl.getCellData(0, i, 1);
		}
		
		return data;
	}

}
