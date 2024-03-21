package com.saucedemo.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	protected WebDriver driver;
	String url, browser;
	protected String userName, passWord;
	
	@BeforeTest
	public void setUp() throws Exception
	{
		JSONParser parser= new JSONParser();
		Object obj1= parser.parse(new FileReader(System.getProperty("user.dir")+"/src/test/resources/data.json"));
		JSONObject obj= (JSONObject) obj1;
		browser=(String) obj.get("browser");
		url=(String) obj.get("url");
		userName= (String) obj.get("user");
		passWord=(String) obj.get("pass");
		if(browser!=null)
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
				driver= new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("edge"))
			{
				driver= new EdgeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				driver= new FirefoxDriver();
			}
			else
			{
				System.out.println("Please provide the browser value in JSON.data as chrome or edge or firefox");
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get(url);
			
		}
		
		
	}
}
