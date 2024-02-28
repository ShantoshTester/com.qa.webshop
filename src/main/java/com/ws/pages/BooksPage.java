package com.ws.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ws.base.DriverScript;

public class BooksPage extends DriverScript {

// ****************************************** Page Elements *************************************************//

	@FindBy(id = "products-pagesize") WebElement displayPerPageDropdown;
	@FindBy(xpath = "//div[@class='item-box']") List<WebElement> booksDisplayFilter;

// ****************************************** Page Initialization *******************************************//

	public BooksPage() {
		PageFactory.initElements(driver, this);
	}

// ****************************************** Page Actions/Methods ******************************************//
	
	public void selectDisplayPerPage(int index) {
		Select select = new Select(displayPerPageDropdown);
		select.selectByIndex(index);
	}
	
	public int getDisplayPerPageResult() {
		return booksDisplayFilter.size();
	}

}
