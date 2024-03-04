package com.appium.TestUtils;


import java.io.FileInputStream;
import java.io.IOException;

import java.time.Duration;

import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.appium.pageObjects.iOS.HomePage;
import com.appium.utils.AppiumUtils;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;


public class iOSBaseTest extends AppiumUtils {
	public AppiumDriverLocalService service;
	public IOSDriver driver;
	public HomePage homePage;
	
@BeforeClass	
public void StartAppiumService() throws IOException {
	
	Properties prop = new Properties();
	FileInputStream fs = new FileInputStream(System.getProperty("user.dir"+"src//main//java//com//appium//resources//config.properties"));
	prop.load(fs);
	String ipAddress = prop.getProperty("ipAddress");
	String port = prop.getProperty("port");
	
	
	
	service = startAppiumServer(ipAddress,Integer.parseInt(port));
	
	XCUITestOptions options = new XCUITestOptions();
	options.setDeviceName("iPhone 13");
	options.setPlatformVersion("15.1");
	options.setApp("");
	options.setWdaLaunchTimeout(Duration.ofSeconds(20));
	
	driver = new IOSDriver(service.getUrl(),options);	
	driver.manage().timeouts().equals(Duration.ofSeconds(5));
	homePage = new HomePage(driver);
	
	}


	
@AfterClass
	public void tearDown() {
		 driver.quit(); 
		  service.stop();
	}

}
