package com.android.tests;


import java.io.IOException;

import java.util.HashMap;

import java.util.List;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.appium.TestUtils.AndroidBaseTest;
import com.appium.TestUtils.ExtentReporterNG;
import com.appium.pageObjects.android.CartPage;
import com.appium.pageObjects.android.ProductsCatalog;





public class TotalSumValidate extends AndroidBaseTest {
	
	
@BeforeMethod(alwaysRun=true)
public void preSetup() {
	
	formPage.setHomeScreenActivity();	
	
}

	
@Test(dataProvider="getTestData",groups={"smoke","Regression"},description="test")	
public void fillForm(HashMap<String,String> input) throws InterruptedException {
	
	
	Thread.sleep(3000);
	formPage.setNameField(input.get("name"));
	formPage.setGender(input.get("gender"));
	formPage.setCountryName(input.get("country"));
	ProductsCatalog productsCatalog = formPage.clickLetsShop();
	

	Thread.sleep(3000);

	String actualProductsTitle = productsCatalog.getTitle();
	Assert.assertEquals(actualProductsTitle, "Products");
	Thread.sleep(2000);
	productsCatalog.addProductsToCartByIndex(0);
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
@DataProvider
public Object[][] getTestData() throws IOException {
	
	List<HashMap<String,String>> data = getJsonData(System.getProperty("user.dir")+"//src//test//java//com//appium//testData//testdata.json");
	
	//return new Object [][] {{"Preethi","female","Argentina"},{"Gnani","male","Australia"},{"Kanishka","female","Algeria"},{"Vishruth","male","Bhutan"}};
	
	return new Object[][] {  {data.get(0)}, {data.get(1)}  };
	
}
	
}
