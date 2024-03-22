package com.saucedemo.PageObjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.ListIterator;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.saucedemo.Abstract.Abstract;

public class HomePage extends Abstract {

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".inventory_item")
	List<WebElement> li;
	
	@FindBy(css=".footer")
	WebElement footer;
	
	
	public void AddToCart(String item)
	{
		WebElement driver2=li.stream().filter(p->p.findElement(By .cssSelector("div.inventory_item_name")).getText().equals(item)).findFirst().orElse(null);
		if(driver2.findElement(By .tagName("button")).getText().equals("Add to cart"))
		{
		driver2.findElement(By .tagName("button")).click();
		}
	}
	
	public void RemoveFromCart(String item)
	{
		WebElement driver2=li.stream().filter(p->p.findElement(By .cssSelector("div.inventory_item_name")).getText().equals(item)).findFirst().orElse(null);
		
		Actions act = new Actions(driver);
		act.scrollToElement(driver2).build().perform();
		if(driver2.findElement(By .tagName("button")).getText().equals("Remove"))
		{
		driver2.findElement(By .tagName("button")).click();
		}
		
		
	}
	
	public void checkBrokenLink() throws MalformedURLException, IOException
	{
		List<WebElement> footerlinks= footer.findElements(By .tagName("a"));
		
		ListIterator<WebElement> a=footerlinks.listIterator();
		
		while(a.hasNext())
		{
			WebElement link= a.next();
			String url= link.getAttribute("href");
			System.out.println(url);
			if(url!=null && !url.isEmpty())
			{
				HttpURLConnection con= (HttpURLConnection) new URL(url).openConnection();
				con.setRequestMethod("HEAD");
				int response= con.getResponseCode();
				System.out.print(response);
				if(response>399)
				{
					Assert.assertFalse(true);
					continue;
				}
				
				
			}
			
		}
		
	}
	

}
