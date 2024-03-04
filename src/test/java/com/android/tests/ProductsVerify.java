package com.android.tests;


import java.io.IOException;

import java.util.HashMap;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.appium.TestUtils.AndroidBaseTest;
import com.appium.pageObjects.android.CartPage;
import com.appium.pageObjects.android.ProductsCatalog;



public class ProductsVerify extends AndroidBaseTest {
	
	
	
@BeforeMethod(alwaysRun=true)
public void preSetup() throws InterruptedException {
	productsCatalog.setProductsCatalogActivity();
	Thread.sleep(4000);

}

	
@Test	
public void fillForm() throws InterruptedException {
	

	/*
	 * String actualProductsTitle = productsCatalog.getTitle();
	 * Assert.assertEquals(actualProductsTitle, "Products");
	 */
	Thread.sleep(4000);
	productsCatalog.addProductsToCartByIndex(0);
	Thread.sleep(3000);
	productsCatalog.addProductsToCartByIndex(0);
	CartPage cartPage = productsCatalog.goToCartPage();
	
	Thread.sleep(3000);
	
	String actualCartTitle = cartPage.getTitle();
	Assert.assertEquals(actualCartTitle, "Cart");
	Thread.sleep(2000);
	double totalSum =cartPage.getProductsSum();
	double displayFormattedSum = cartPage.getTotalAmountDisplayed();
	Assert.assertEquals(totalSum, displayFormattedSum);
	cartPage.acceptTermsAndConditions();
	cartPage.clickCheckbox();
	Thread.sleep(2000);
	  
	 
}

	
}
