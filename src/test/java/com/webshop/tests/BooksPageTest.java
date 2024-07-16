package com.webshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BooksPageTest extends BaseTest {
	
	
	@Test(priority = 1)
	public void testBookPageTitle() {
		logger = report.createTest("test books page title");
		homePage.clickBooksMenu();
		logger.pass("clicked on books menu");
		String title = booksPage.getBooksPageTitle();
		logger.pass("got the page title");
		Assert.assertTrue(title.contains("Books"));
		logger.pass("verified the page title contains books");
	}
	
	@Test(priority = 2)
	public void testDisplaySize() throws InterruptedException {
		logger = report.createTest("test books display size");
		homePage.clickBooksMenu();
		logger.pass("clicked on books menu");
		String title = booksPage.getBooksPageTitle();
		logger.pass("got the page title");
		Assert.assertTrue(title.contains("Books"));
		booksPage.changeDisplaySize(2);
		Thread.sleep(3000);
		int expected = 6;
		int actual = booksPage.getBooksGridSize();
		System.out.println(actual);
		Assert.assertEquals(actual,expected);
	
		
	}
	
	

}
