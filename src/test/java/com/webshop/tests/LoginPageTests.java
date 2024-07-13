package com.webshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {
	

	@Test(priority = 1)
	public void testLoginPageTitle() {
		logger = report.createTest("test login page title");
		homePage.clickLoginLink();
		logger.pass("clicked on login link");
		String pageTitle = loginPage.getLoginPageTitle();
		logger.pass("got the login page title");
		Assert.assertTrue(pageTitle.contains("Login"));
		logger.pass("login page title matched");
	}
	
	
	@Test(priority = 2)
	public void testWelcomeSignIn() {
		logger = report.createTest("test welcome sign in");
		homePage.clickLoginLink();
		logger.pass("clicked on login link");
		String actual = loginPage.validateWelcomeText();
		System.out.println(actual);
		logger.pass("retrived the text from welcome sign in");
		Assert.assertTrue(actual.contains("Welcome"));
		logger.pass("text contains welcome word");

	}
	
	@Test(priority = 3)
	public void testForgotPasswordIsDisplayed() {
		logger = report.createTest("test forgot password link is displayed");
		homePage.clickLoginLink();
		logger.pass("clicked on login link");
		boolean flag = loginPage.isForgotPasswordLinkPresent();
		System.out.println(flag);
		logger.pass("element forgot password link is located");
		Assert.assertTrue(flag);
		logger.pass("forgot password link is displayed");
	}
	
	@Test(priority = 4)
	public void testLoginFunction() {
		logger = report.createTest("test login functionality");
		homePage.clickLoginLink();
		logger.info("clicked on login link");
		loginPage.enterEmailId("selauto1@test.com");
		logger.info("entered email id");
		loginPage.enterPassword("Pass@123");
		logger.info("entered password");
		loginPage.clickLoginButton();
		logger.info("clicked on login button");
		boolean flag = homePage.isLogoutLinkPresent();
		System.out.println(flag);
		logger.info("located logout link");
		Assert.assertTrue(flag);
		logger.pass("user able to successfully log in");
		homePage.clickLogout();
		logger.info("clicked on logout");
	}
	
	@Test(priority = 5)
	public void testLoginInvalidCredientials() {
		logger = report.createTest("test login functionality");
		homePage.clickLoginLink();
		logger.info("clicked on login link");
		loginPage.enterEmailId("selauto1@test.com");
		logger.info("entered email id");
		loginPage.enterPassword("");
		logger.info("entered password");
		loginPage.clickLoginButton();
		logger.info("clicked on login button");
		boolean flag = homePage.isLogoutLinkPresent();
		System.out.println(flag);
		logger.info("located logout link");
		Assert.assertTrue(flag);
		logger.pass("user able to successfully log in");
		homePage.clickLogout();
		logger.info("clicked on logout");
	}

}
