package com.plug.ecommerce.objectrepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	

	@FindBy(xpath = "//input[@type='email']")
	private WebElement emailTextField;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordTextField;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;

	
	public LoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	
	public void loginToApp(
			String username,
			String password) {

		emailTextField.sendKeys(username);

		passwordTextField.sendKeys(password);

		loginButton.click();
	}
}
