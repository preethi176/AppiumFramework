package com.appium.pageObjects.android;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.appium.utils.AndroidActions;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions {
	
	AndroidDriver driver;
	
	
public FormPage(AndroidDriver driver) {
	
	super(driver);
	this.driver = driver;
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	
}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;

	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleOption;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	private WebElement maleOption;
	
	@AndroidFindBy(id="android:id/text1")
	private WebElement clickCountryList;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement letsShopButton;
	
	
	
	
	
	public void setNameField(String name) {
		nameField.sendKeys(name);
		
	}
	public void setGender(String gender) {
		if(gender.contains("female")) {
			femaleOption.click();
		}
		else
			maleOption.click();
	}
	public void setCountryName(String countryName) {
		clickCountryList.click();
		ScrollToSpecificText(countryName);
		clickSpecificText(countryName);
	}
	public ProductsCatalog clickLetsShop() {
		letsShopButton.click();
		return new ProductsCatalog(driver);
		
	}
	public void setHomeScreenActivity() {
			Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
			((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
				    "intent", "com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"));
			
		}
	
	}


