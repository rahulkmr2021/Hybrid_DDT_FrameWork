package com.healthcare.PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminUserPage {
	WebDriver rdriver;

	public AdminUserPage(WebDriver lDriver) {
		rdriver=lDriver;
		PageFactory.initElements(lDriver, this);	
	}

	
	}





