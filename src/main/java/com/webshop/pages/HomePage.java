package com.webshop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webshop.base.DriverScript;

public class HomePage extends DriverScript {
	
// ******************************************** Page Locators ***************************************//	
	
	@FindBy(linkText = "Log in") private WebElement loginLink;
	@FindBy(linkText = "Log out") private WebElement logoutLink;
	
	
// ******************************************** Page Initialization ********************************//		
	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
// ******************************************** Page Methods/Action ********************************//
	
	public boolean isLogoutLinkPresent() {
		return logoutLink.isDisplayed();
	}
	
	public void clickLogout() {
		logoutLink.click();
	}
	
	public void clickLoginLink() {
		loginLink.click();
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}

}
