package com.android.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.appium.TestUtils.AndroidBaseTest;
import io.appium.java_client.AppiumBy;


public class TestCase extends AndroidBaseTest{
	
	@BeforeMethod
	public void preSetup() {
		
		formPage.setHomeScreenActivity();	
	}
	
	
	@Test(priority=1)
	public void verifyErrorMsg() throws InterruptedException {
		Thread.sleep(3000);
	
	//driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Preethi");
	driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale")).click();
	formPage.setCountryName("Algeria");
	driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	
	  String toastMsg =driver.findElement(AppiumBy.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
	  Assert.assertEquals(toastMsg,"Please enter name");
	 
	}
	
	
	  @Test(priority=2) public void PositiveFlow() throws InterruptedException {
	  Thread.sleep(3000);
	  
	  driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")
	  ).sendKeys("Preethi"); driver.findElement(AppiumBy.id(
	  "com.androidsample.generalstore:id/radioFemale")).click();
	  formPage.setCountryName("Algeria"); driver.findElement(AppiumBy.id(
	  "com.androidsample.generalstore:id/btnLetsShop")).click();
	  Assert.assertTrue(driver.findElements(AppiumBy.xpath(
	  "(//android.widget.Toast)")).size()<1);
	  
	  }
	 
}
