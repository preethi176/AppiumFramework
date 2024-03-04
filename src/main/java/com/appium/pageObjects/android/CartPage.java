package com.appium.pageObjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.appium.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions {
	
	AndroidDriver driver;
	
	public CartPage(AndroidDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
	private WebElement title;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productsPrice;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	private WebElement termsAndConditions;
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement Accept;
	
	@AndroidFindBy(className="android.widget.CheckBox")
	private WebElement checkBox;
	
	
	
	public String getTitle() {
		 String actualTitle = title.getText();
		return actualTitle;
	}
	
	public List<WebElement> getProductList(){
		return productsPrice;
		
	}
	public double getProductsSum() {
		int count = productsPrice.size();
		double totalSum =0;
		for(int i=0;i<count;i++) {
			String amountString = productsPrice.get(i).getText();
			Double price = getFormattedAmount(amountString);
			totalSum = totalSum + price;
		}
		return totalSum;
	}

public Double getTotalAmountDisplayed() {
	return getFormattedAmount(totalAmount.getText());
}

public void acceptTermsAndConditions() {
	longPressAction(termsAndConditions);
	Accept.click();
}


public void clickCheckbox() {
	checkBox.click();
}

	

}
