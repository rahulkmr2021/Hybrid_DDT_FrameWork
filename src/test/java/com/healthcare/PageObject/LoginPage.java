package com.healthcare.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver rdriver;

	public LoginPage(WebDriver lDriver) {
		rdriver=lDriver;
		PageFactory.initElements(lDriver, this);	
	}
	
	@FindBy(xpath="//input[@type='email']")
	@CacheLookup
	public WebElement email;

	@FindBy(xpath="//input[@type='password']")
	@CacheLookup
	public WebElement password;

	@FindBy(xpath="//button[@class='btn-submit']")
	@CacheLookup
	public WebElement btnLogin;
	
	
	public void UserName(String name) {
		
		email.sendKeys(name);
		
	}
	public void password01(String pass) {
		
		password.sendKeys(pass);
		
	}
	public void Login() {
		
		btnLogin.click();
		
	}

}
