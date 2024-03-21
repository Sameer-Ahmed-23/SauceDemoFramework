package com.saucedemo.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.Abstract.Abstract;

public class LandingPage extends Abstract {
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-name")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(css="input[type='submit']")
	WebElement Button;
	
	public HomePage Login(String user, String pass)
	{
		userName.clear();
		userName.sendKeys(user);
		password.clear();
	    password.sendKeys(pass);
	    Button.click();
	    return new HomePage(driver);
	    
	}
	

}
