package com.saucedemo.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.Abstract.Abstract;

public class HomePage extends Abstract {

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".inventory_item")
	List<WebElement> li;
	
	public void AddToCart(String item)
	{
		WebElement driver2=li.stream().filter(p->p.findElement(By .cssSelector("div.inventory_item_name")).getText().equals(item)).findFirst().orElse(null);
		driver2.findElement(By .tagName("button")).click();
	}
	

}
