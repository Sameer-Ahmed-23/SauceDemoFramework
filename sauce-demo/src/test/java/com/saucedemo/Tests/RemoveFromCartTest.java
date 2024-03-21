package com.saucedemo.Tests;

import org.testng.annotations.Test;

import com.saucedemo.Base.BaseTest;

public class RemoveFromCartTest extends AddToCartTest{
	
	@Test(dependsOnMethods= {"AddToCart"})
	public void RemoveFromCart()
	{
		h.RemoveFromCart("Sauce Labs Bolt T-Shirt");
	}

}
