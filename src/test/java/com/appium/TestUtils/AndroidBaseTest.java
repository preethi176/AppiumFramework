package com.appium.TestUtils;

import java.io.FileInputStream;
import java.io.IOException;

import java.time.Duration;
import java.util.Properties;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.appium.pageObjects.android.FormPage;
import com.appium.pageObjects.android.ProductsCatalog;
import com.appium.utils.AppiumUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;


public class AndroidBaseTest extends AppiumUtils {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public FormPage formPage;
	public ProductsCatalog productsCatalog;
	
	
	
	
@BeforeClass(alwaysRun=true)
public void StartAppiumService() throws IOException {
	
	Properties prop = new Properties();
	FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//com//appium//resources//config.properties");
	String ipAddress = System.getProperty("ipAddress")!=null ? System.getProperty("ipAddress") : prop.getProperty("ipAddress");
	prop.load(fs);
	//String ipAddress = prop.getProperty("ipAddress");
	String port = prop.getProperty("port");

	
	service = startAppiumServer(ipAddress,Integer.parseInt(port));
	
	/*
	 * DesiredCapabilities caps = new DesiredCapabilities();
	 * caps.setCapability("deviceName", "Android Emulator");
	 * caps.setCapability("platformName", "Android");
	 * //caps.setCapability("platformVersion", "13");
	 * caps.setCapability("automationName", "uiautomator2");
	 * 
	 * 
	 * // caps.setCapability("appPackage", "com.google.android.apps.nexuslauncher");
	 * // caps.setCapability("appActivity",
	 * "com.google.android.apps.nexuslauncher.NexusLauncherActivity");
	 * 
	 * caps.setCapability("app", "C:\\Personal\\apk files\\General-Store.apk");
	 */
	
	UiAutomator2Options options = new UiAutomator2Options();
	options.setDeviceName("Android Emulator");
	//For real device
	//options.setDeviceName("Android Device");
	options.setApp(System.getProperty("user.dir")+"//src//test//java//com//tests//resources//apk_files//General-Store.apk");
	options.setPlatformName("Android");
	

	
	driver = new AndroidDriver(service.getUrl(),options);	
	driver.manage().timeouts().equals(Duration.ofSeconds(5));
	formPage = new FormPage(driver);
	productsCatalog= new ProductsCatalog(driver);
	
	
	}

	
@AfterClass(alwaysRun=true)
	public void tearDown() {
		 driver.quit(); 
		  service.stop();
	}

}
