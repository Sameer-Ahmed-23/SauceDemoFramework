package com.saucedemo.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.saucedemo.Base.BaseTest;
import com.saucedemo.PageObjects.HomePage;
import com.saucedemo.PageObjects.LandingPage;

public class AddToCartTest extends BaseTest {
	
	HomePage h;
	@Test(priority=0)
	public void Login()
	{
		LandingPage la= new LandingPage(driver);
		h=la.Login(userName, passWord);
	}
	
	@Test(dependsOnMethods= {"Login"})
	public void AddToCart()
	{
		h.AddToCart("Sauce Labs Bolt T-Shirt");
	}

}
