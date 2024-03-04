package com.iOS.tests;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.appium.TestUtils.iOSBaseTest;
import com.appium.pageObjects.iOS.AlertViews;

import io.appium.java_client.AppiumBy;


public class iOSBasics extends iOSBaseTest{
	
@Test	
public void iOSBasicsTest() {
	AlertViews alertViews = homePage.clickAlertViews();
	alertViews.clickConfirmCancel();
}

}
