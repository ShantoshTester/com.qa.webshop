package com.webshop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.webshop.base.DriverScript;

public class LoginPage extends DriverScript {

// ******************************************** Page Locators ***************************************//	
	
	@FindBy(id = "Email") private WebElement emailTextbox;
	@FindBy(name = "Password") private WebElement passwordTextbox;
	@FindBy(xpath = "//input[@class='button-1 login-button']") private WebElement loginButton;
	@FindBy(xpath = "//h1[text()='Welcome, Please Sign In!']") private WebElement welcomeSignText;
	@FindBy(linkText = "Forgot password?") private WebElement forgotPasswordLink;

// ******************************************** Page Initialization ********************************//		

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

// ******************************************** Page Methods/Action ********************************//
	
	public boolean isForgotPasswordLinkPresent()
	{
		return forgotPasswordLink.isDisplayed();
	}
	
	public String validateWelcomeText() {
		return welcomeSignText.getText();
	}
	
	public void enterEmailId(String emailId) {
		emailTextbox.sendKeys(emailId);
	}
	
	public void enterPassword(String password) {
		passwordTextbox.sendKeys(password);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

}
