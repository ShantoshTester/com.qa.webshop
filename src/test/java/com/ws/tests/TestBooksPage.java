package com.ws.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestBooksPage extends BaseTest {
	
	@Test
	public void testDisplayPerPageFilter() {
		int actual = 4;
		logger = report.createTest("Test Perpage Filter Dropdown");
		homePage.clickBooksMenu();
		logger.pass("clicked books menu");
		booksPage.selectDisplayPerPage(0);
		logger.pass("selected the dropdown value as 4");
		int expected = booksPage.getDisplayPerPageResult();
		Assert.assertEquals(actual, expected);
		logger.pass("verified the books count from the selected dropdown count");
		System.out.println(expected);
		
	}

}
