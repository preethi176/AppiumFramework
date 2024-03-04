package com.appium.TestUtils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG  {
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static ExtentReports getReporterObject() {
	
	String path = System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Mobile Automation Report");
	reporter.config().setDocumentTitle("Test Automation Results");
	
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Preethi K");
	
	return extent;	
	
	}
	

}
