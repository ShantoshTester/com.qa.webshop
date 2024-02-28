package com.ws.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestComputersPage extends BaseTest {
	
	@Test
	public void testComputerPage() {
		logger = report.createTest("Test Computers Page is Displayed");
		homePage.clickComputerMenu();
		logger.pass("clicked computers menu");
		String pageText = computersPage.getComputersHeaderText();
		Assert.assertTrue(pageText.contains("Computers"));
		logger.pass("computers page verified");
	}

}
