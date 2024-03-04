package com.appium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions extends AppiumUtils {
	AndroidDriver driver;
	
	public AndroidActions(AndroidDriver driver) {
		this.driver=driver;
	}
	
	public void longPressAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(),
						        "duration", 2000));
		
	}
	public void scrollToEnd() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));
		}
		while(canScrollMore);
	}
	public void SwipeAction(WebElement ele, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				   "elementId", ((RemoteWebElement ) ele).getId(),
				    "direction", direction,
				    "percent", 0.75
				));
	}
	public void DragAndDropAction(WebElement ele, int endX, int endY) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),
			    "endX", endX,
			    "endY", endY
			));
	}
	public void ScrollToSpecificText(String text) {
		driver.findElement(AppiumBy.androidUIAutomator
				 ("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
	}
	public void clickSpecificText(String text) {
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\""+text+"\"]")).click();
	}
	public void addProductToCart(String nameOfTheProduct) {
		int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for (int i=0; i<productCount;i++) {
			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if (productName.equals(nameOfTheProduct)) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}
		
		
	}


}
