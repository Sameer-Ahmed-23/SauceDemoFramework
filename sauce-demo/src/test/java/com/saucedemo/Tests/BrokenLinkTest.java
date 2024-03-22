package com.saucedemo.Tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.http.HttpResponse;

import org.testng.annotations.Test;

import com.saucedemo.Base.BaseTest;
import com.saucedemo.PageObjects.LandingPage;

public class BrokenLinkTest extends BaseTest {
	
	@Test
	public void Login()
	{
		LandingPage la= new LandingPage(driver);
		h=la.Login(userName, passWord);
	}
	
	@Test(dependsOnMethods= {"Login"})
	public void BrokenLink() throws Exception, IOException
	{
		h.checkBrokenLink();
	}
	
	

}
