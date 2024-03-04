package com.appium.TestUtils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.appium.utils.AppiumUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.appium.java_client.AppiumDriver;


public class Listeners extends AppiumUtils implements ITestListener{
	ExtentTest test;
	 ExtentReports extent = ExtentReporterNG.getReporterObject();
	AppiumDriver driver;
	
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 test= extent.createTest(result.getMethod().getMethodName());
		 
		 
		 
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String logTest = "Test Method " + result.getMethod().getMethodName() + " is Successful";
		Markup m = MarkupHelper.createLabel(logTest, ExtentColor.GREEN);
		// TODO Auto-generated method stub
		test.log(Status.PASS, m);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//screenshot code
		test.fail(result.getThrowable());
		
		try {
			driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		try {
			test.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(),driver), result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	 

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}
	/*
	 * //Method for adding logs passed from test cases public void reportLog(String
	 * message) { test.log(Status.INFO, message);//For extentTest HTML report
	 * Log.info("Message: " + message); Reporter.log(message);
	 * 
	 * 
	 * }
	 */

	
}

	



	


	
	


