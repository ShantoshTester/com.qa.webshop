package com.webshop.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.webshop.base.DriverScript;

public class BooksPage extends DriverScript {

// ******************************************** Page Locators ***************************************//	

	@FindBy(xpath = "//h1[text()='Books']") private WebElement booksText;
	@FindBy(id = "products-pagesize") private WebElement displayDropdown;
	@FindBy(xpath = "//div[@class='product-grid']/div") private List<WebElement> booksGrid;

// ******************************************** Page Initialization ********************************//		

	public BooksPage() {
		PageFactory.initElements(driver, this);
	}

// ******************************************** Page Methods/Action ********************************//
	
	public int getBooksGridSize() {
		return booksGrid.size();
	}
	
	public String getBooksPageTitle() {
		return driver.getTitle();
	}
	
	public String getBooksText() {
		return booksText.getText();
	}
	
	public void changeDisplaySize(int index) {
		Select select = new Select(displayDropdown);
		select.selectByIndex(index);
	}

}
