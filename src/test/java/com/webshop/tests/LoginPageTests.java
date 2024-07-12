package com.webshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {
	

	@Test(priority = 1)
	public void testLoginPageTitle() {
		homePage.clickLoginLink();
		String pageTitle = loginPage.getLoginPageTitle();
		Assert.assertTrue(pageTitle.contains("Login"));
	}
	
	
	@Test(priority = 2)
	public void testWelcomeSignIn() {
		homePage.clickLoginLink();
		String actual = loginPage.validateWelcomeText();
		System.out.println(actual);
		Assert.assertTrue(actual.contains("Welcome"));

	}
	
	@Test(priority = 3)
	public void testForgotPasswordIsDisplayed() {
		homePage.clickLoginLink();
		boolean flag = loginPage.isForgotPasswordLinkPresent();
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 4)
	public void testLoginFunction() {
		homePage.clickLoginLink();
		loginPage.enterEmailId("selauto1@test.com");
		loginPage.enterPassword("Pass@123");
		loginPage.clickLoginButton();
		boolean flag = homePage.isLogoutLinkPresent();
		System.out.println(flag);
		Assert.assertTrue(flag);
		homePage.clickLogout();
	}

}
