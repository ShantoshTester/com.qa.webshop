package com.webshop.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.webshop.base.DriverScript;
import com.webshop.pages.HomePage;
import com.webshop.pages.LoginPage;

public class BaseTest extends DriverScript {
	
	HomePage homePage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp() {
		initApplication();
		homePage = new HomePage();
		loginPage = new LoginPage();
	}
	
	@AfterMethod
	public void tearDown() {
		quitDriver();
	}

}
