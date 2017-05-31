package Tests;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestNGTest {
	private static AndroidDriver driver;
	
  
  @Test
public void test1() {
	 
//	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/myButton").click();
//	  driver.findElementById("android:id/topPanel");
//	  driver.findElementById("android:id/message").getText().equals("OTP should not be less than 8 digits");
//	  
  }
  @Test
public void test2() {
//	  //Register successfully
//	  driver.findElementByXPath("//*[1]//*[1]//*[1]//*[1]//*[2]").sendKeys("12345678");
//	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/myButton").click();
//	  //click on a survey and see survey details
//	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/surveyListView").isDisplayed();
//	   driver.findElementByXPath("//*[1]//*[1]//*[1]//*[1]//*[4]//*[1]//*[1]").click();
//	   driver.findElementByXPath("//*[1]//*[1]//*[1]//*[1]//*[2]//*[2]//*[1]//*[1]").getText().equals("A bundle of command-line tools for managing SQLite database files, including the command-line shell program, the sqldiff");
//	   //navigate back to home page
//	   driver.navigate().back();
//	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/surveyListView");
//	   //See additional details of survey on Home page
//	   driver.findElementByXPath("//*[1]//*[1]//*[1]//*[1]//*[4]//*[1]//*[1]//*[1]//*[1]//*[1]//*[1]").click();
//	   driver.findElementByXPath("//*[1]//*[1]//*[1]//*[1]//*[4]//*[1]//*[1]//*[1]//*[1]//*[1]//*[1]//*[1]").getText().equals("This survey is to improve overall catering services available in SS building");
//	   driver.findElementByXPath("//*[1]//*[1]//*[1]//*[1]//*[4]//*[1]//*[1]//*[1]//*[1]//*[1]//*[2]//*[1]").click();
  }
  
  
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException, InterruptedException {
//
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability("deviceName","Nexus6P");		
//		capabilities.setCapability("platformVersion", "6.0");
//		capabilities.setCapability("platformName", "Android");
//		capabilities. setCapability("app", "/Users/vinodh/Downloads/WellsFargo.Echo.Droid.UI-Signed.apk");
//		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
//	    		Thread.sleep(10000);
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
//	  driver.quit();
  }

}
