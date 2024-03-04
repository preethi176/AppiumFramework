package com.appium.pageObjects.iOS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.appium.utils.iOSActions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AlertViews extends iOSActions {
	
	IOSDriver driver;
	
public AlertViews(IOSDriver driver) {
	
	super(driver);
	this.driver = driver;
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	
}
@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeStaticText[`name='Text Entry'`]")
private WebElement textEntryMenu;

@iOSXCUITFindBy(iOSNsPredicate="type == XCUIElementTypeStaticText AND value == 'Confirm / Cancel'")
private WebElement ConfirmCancelBtn;

public void clickAlertViews() {
	textEntryMenu.click();
}
public void clickConfirmCancel() {
	ConfirmCancelBtn.click();
}

}
