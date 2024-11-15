package com.saucedemo.Base;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ReportListener extends BaseTest implements ITestListener {
	
	ExtentTest test;
	
	ExtentReports extent = ReporterObject();
	
	public void onTestStart(ITestResult result)
	{
		test=extent.createTest(result.getMethod().getMethodName());
	}
	
	private Object Reporter() {
		// TODO Auto-generated method stub
		return null;
	}

	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS, "Test Passed");
		String path="";
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (driver!=null)
		{
			try {
				path= getScreenShots(result.getName(), driver);
				driver.quit();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		test.addScreenCaptureFromPath(path);
	}
	
	public void onTestFailure(ITestResult result)
	{
		test.fail(result.getThrowable());
		String path="";
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			path = getStringShots(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(path);
		driver.quit();
	}
	
	

	

	public void onFinish(ITestContext result)
	{
		extent.flush();
	}

}
