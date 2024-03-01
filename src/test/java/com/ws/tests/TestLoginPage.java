package com.ws.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginPage extends BaseTest {
	
	@Test(priority = 4)
	public void testInvalidEmailErr() {
		logger = report.createTest("Validating Error Message for Invalid Email");
		homePage.clickLogin();
		logger.pass("clicked login link");
		loginPage.enterEmail("username");
		loginPage.clickLoginButton();
		String emailErrMsg = loginPage.getInvalidEmailErrMsg();
		System.out.println(emailErrMsg);
		Assert.assertTrue(emailErrMsg.contains("enter a valid email address"));
		logger.pass("verified invalid email error message");
	}
	

	@Test(priority = 1)
	public void testHomePageTitle() 
	{
		logger = report.createTest("Validating HomePage Title");
		String title = homePage.getHomePageTitle();
		logger.pass("got the homepage title");
		Assert.assertTrue(title.contains("Demo Web Shop"));
		logger.pass("verified homepage title successuflly");
	}
	
	@Test(dataProvider = "wsdata", priority = 2)
	public void testLoginFunction(String username, String password) {
		logger = report.createTest("Validating Login Function");
		homePage.clickLogin();
		logger.pass("clicked login link");
		String loginPageTitle = loginPage.getLoginPageTitle();
		Assert.assertTrue(loginPageTitle.contains("Login"));
		logger.pass("verified login title successuflly");
		loginPage.enterEmail(username);
		logger.pass("entered username");
		loginPage.enterPassword(password);
		logger.pass("entered password");
		loginPage.clickLoginButton();
		logger.pass("clicked login button");
		String title = homePage.getHomePageTitle();
		Assert.assertTrue(title.contains("Demo Web Shop"));
		logger.pass("verified homepage title successuflly");
		homePage.clickLogout();
		logger.pass("clicked logout link");
	}
	
	@Test(priority = 3)
	public void testIsForgotpasswordLinkPresent() 
	{
		logger = report.createTest("Validating ForgotPassword Link is Present");
		homePage.clickLogin();
		logger.pass("clicked login link");
		String loginPageTitle = loginPage.getLoginPageTitle();
		Assert.assertTrue(loginPageTitle.contains("Login"));
		boolean flag = loginPage.isForgotpasswordLinkPresent();
		Assert.assertTrue(flag);
		logger.pass("forgot password link is present");
	}

}


