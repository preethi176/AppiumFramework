package com.appium.pageObjects.android;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.appium.utils.AndroidActions;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductsCatalog extends AndroidActions {
	
	AndroidDriver driver;

	
public ProductsCatalog(AndroidDriver driver) {
	
	super(driver);
	this.driver = driver;
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	
}
@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
private List<WebElement> products;

@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
private WebElement addCart;

@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
private WebElement title;

public void addProductsToCartByIndex(int index) {
	int size = products.size();
	System.out.println(size);
	products.get(index).click();
	
}
public CartPage goToCartPage() {
	addCart.click();
	return new CartPage(driver);
}

public String getTitle() {
	 String actualTitle = title.getText();
	return actualTitle;
}

public void setProductsCatalogActivity() {
	Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.AllProductsActivity");
	((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
		    "intent", "com.androidsample.generalstore/com.androidsample.generalstore.AllProductsActivity"));
}



}
