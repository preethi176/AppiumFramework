package com.appium.utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class iOSActions extends AppiumUtils{
	
	IOSDriver driver;
	
	public iOSActions(IOSDriver driver) {
		this.driver=driver;
	}
	
	public void longPress(WebElement ele) {
		Map<String,Object> params = new HashMap<>();
		params.put("element", ((RemoteWebElement)ele).getId());
		params.put("duration", 5);
		
		driver.executeScript("mobile:touchAndHold", params);
	}
	public void scrollDowntoWebElement(WebElement ele) {
		Map<String,Object> params = new HashMap<>();
		params.put("element", ((RemoteWebElement)ele).getId());
		params.put("direction", "down");
		
		driver.executeScript("mobile:scroll", params);
	}


}
