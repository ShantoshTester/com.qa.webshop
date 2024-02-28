package com.ws.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ws.base.DriverScript;

public class ComputersPage extends DriverScript {
	
// ****************************************** Page Elements *************************************************//
	
	@FindBy(xpath = "//h1") WebElement computersText;
	
	
// ****************************************** Page Initialization *******************************************//
	
	public ComputersPage() {
		PageFactory.initElements(driver, this);
	}
	
// ****************************************** Page Actions/Methods ******************************************//
	
	public String getComputersHeaderText() {
		return computersText.getText();
	}

}
