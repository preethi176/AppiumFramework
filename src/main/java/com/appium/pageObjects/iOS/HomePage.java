package com.appium.pageObjects.iOS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.appium.utils.iOSActions;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;



public class HomePage extends iOSActions {
	
	IOSDriver driver;
	
public HomePage(IOSDriver driver) {
	
	super(driver);
	this.driver = driver;
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	
}
@iOSXCUITFindBy(accessibility="Alert Views")
private WebElement alertViews;

public AlertViews clickAlertViews() {
	alertViews.click();
	return new AlertViews(driver);
}
}
