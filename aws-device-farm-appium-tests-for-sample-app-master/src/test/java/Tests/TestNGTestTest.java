package Tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;


public class TestNGTestTest {
	private static AndroidDriver driver;
	@AfterSuite
  public void afterMethod() {

	  driver.quit();
  }

  @BeforeSuite
  public void beforeMethod() throws MalformedURLException, InterruptedException {
	  DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName","Samsung Galaxy S7");		
		capabilities.setCapability("platformVersion", "6.0");
		capabilities.setCapability("platformName", "Android");
		capabilities. setCapability("app", "/Users/vinodh/Downloads/WellsFargo.Echo.Droid.UI-Signed295.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	    		Thread.sleep(10000);
	  
  }

  @Test (priority =0)
  public void TC_Splash_screen_02() {
	  //splash screen 
	   driver.findElementById("android:id/content").isDisplayed();
  }
	
   @Test (priority =1)
	   public void TC_URN_Screen_UI_01() {
	   //Verify UI in Home screen 
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtOTPLabel").getText().equals("Enter Code");
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtPassword").isDisplayed();
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/btnSubmitURN").isDisplayed();
   }
   @Test (priority =2)
   public void TC_Wrong_URN_Message_01() {
	   //Empty URN field
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/btnSubmitURN").click();
		  driver.findElementById("android:id/title_template");
		  driver.findElementById("android:id/message").getText().equals("OTP should not be less than 8 digits");
		  takeScreenshot("testscr");
		  driver.findElementById("android:id/button1").click();
   }
   @Test (priority =3)
   public void TC_Wrong_URN_Message_01_02() {
	  //Wrong URN
	  driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtPassword").sendKeys("11111111");
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/btnSubmitURN").click();
		  driver.findElementById("android:id/title_template");
		  driver.findElementById("android:id/message").getText().equals("Authentication failed. Please contact administrator for more details.");
	   takeScreenshot("testscr");
	   driver.findElementById("android:id/button1").click();
  }

  @Test (priority=4)
  public void TC_URN_Screen_Enter_code__() {
	  //Register successfully
	  driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtPassword").sendKeys("99083333");
	  takeScreenshot("testscr");
	  driver.findElementById("WellsFargo.Echo.Droid.UI:id/btnSubmitURN").click();
  }
  @Test (priority=5)
  public void TC_Home_Page_UI_TC_Home_Page() {
	  //Check app name
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtEcho").getText().equals("PULSE");
  }
  @Test (priority=6)
  public void TC_HomePage_Surveyfeedback_count_() {
	
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtSurvey").getText().equals("SURVEY - 3");
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtFeedback").getText().equals("	FEEDBACK - 0");
  }
  @Test (priority=7)
  public void TC_HomePage_ActiveSurvey_() {
	  
	  //pin the survey first
	  driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtSurveyTitle").click();
	  driver.findElementById("WellsFargo.Echo.Droid.UI:id/imgPin").click();
	  driver.navigate().back();
	 
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtAll").isDisplayed();
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtPinned").isDisplayed();
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtStarted").isDisplayed();
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtSurveyTitle").getText().equals("Catering Services for SS building");
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtByLabel").isDisplayed();
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtCategoryName").getText().equals("Catering Services");
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/imgExpandCollapse").isDisplayed();
  }
//  @Test (priority=8)
//  public void TC_HomePage_Survey_iconsTC_HomePage_Surveylist_UI_() {
//	  
//	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/imgUnpin").isDisplayed();
//	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/imgPercent").isDisplayed();
//  }
  @Test (priority=9)
  public void TC_HomePage_SwipeSurveylist_05() {
	
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtPercent").getText().equals("49%");
	
  }
  @Test (priority=10)
  public void TC_HomePage_SwipeSurveylist_06() {
 
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtHoursDayLeft").getText().equals("133 Days Left");
  }
  @Test (priority=10)
  public void TC_HomePage_EmpPoint_() {
	 
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtProfileScore").isDisplayed();
  }
  @Test (priority=11)
  public void TC_HomePage_Emppoint_pointsearned_() {
  
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtProfileScore").getText().equals("10");
  }
  @Test (priority=12)
  public void TC_Search_icon_() {
    
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/SearchIcon").isDisplayed();
  }
  @Test (priority=13)
  public void TC_Filter_icon_TC_Feedback_Filter_icon_() {
	  
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/SettingsIcon").isDisplayed();
  }
  @Test (priority=14)
  public void TC_HomePage_BottomNavigation_icons_01() {
  //Check for navigation drawer icons 
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/imgHome").isDisplayed();
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/imgMessage").isDisplayed();
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/imgBarcode").isDisplayed();
	   takeScreenshot("testscr");
  }
  @Test (priority=15)
  public void TC_HomePage_BottomNavigation_04() {
	 
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/imgHome").click();
  }
  @Test (priority=16)
  public void TC_HomePage_Surveylist_02() {
	   
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/imgUnpin").click();
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtPinned").click();
	   takeScreenshot("testscr");
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/lytSurveyDetail").isDisplayed();
  }
  @Test (priority=17)
  public void TC_HomePage_Surveylist_03() {
	  
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtStarted").click();
	   takeScreenshot("testscr");
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtStarted").isDisplayed();
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/lytSurveyDetail").isDisplayed();
  }
  @Test (priority=18)
  public void TC_HomePage_SwipeSurveylist_01() {
	   
	   driver.scrollToExact("Catering Services");
	   takeScreenshot("testscr");
  }
//  @Test (priority=19)
//  public void TC_HomePage_SwipeSurveylist_04() {
//	
//	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/imgUnpin").click();
//	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/imgPin").isDisplayed();
//	   takeScreenshot("testscr");
//  }
  @Test (priority=20)
  public void TC_HomePage_SurveyDetails_01() {
	   
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/imgExpandCollapse").click();
	  
  }
  @Test (priority=21)
  public void TC_HomePage_SurveyDetails_04() {
  
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtSurveyIntroduction").isDisplayed();
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtEndDate").isDisplayed();
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtSurveyIntroShort").isDisplayed();
	 
  }
  @Test (priority=22)
  public void TC_HomePage_SurveyDetails_05() {
  
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtEndDate").getText().equals("Please respond by October 06, 2017.");
	   takeScreenshot("testscr");
  }
  @Test (priority=23)
  public void TC_HomePage_SurveyDetails_03() {
	   
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/imgExpandCollapse").click();
  }
  @Test (priority=24)
  public void TC_HomePage_initiatessurveyresponse_TC_Surveypage_1() {
	 
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtSurveyTitle").click();
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtSurveyIntroduction").getText().equals("This survey is to improve overall catering services available in SS building");
	   takeScreenshot("testscr");
  }
  @Test (priority=25)
  public void TC_Surveypage_2() {
	  
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtInstruction").getText().equals("If any question, please email to poc@wellsfargo.com with subject as Catering Services for SS building"); 
  }
  @Test (priority=26)
  public void TC_HomePage_SurveyDetails_header_() {
  
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtSurveyTitle").getText().equals("Catering Services for SS building");
  }   
  @Test (priority=27)
  public void TC_Surveypage_intro_01() {	  

  driver.findElementById("WellsFargo.Echo.Droid.UI:id/imgBackButton").click();
  driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtEcho").isDisplayed();
  }
  @Test (priority=28)
  public void TC_Surveypage_intro_03() {
	  driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtSurveyTitle").click();
  driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtEndDate").isDisplayed();
  driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtSurveyConductedBy").isDisplayed();
  }
  
  @Test (priority=28)
  public void TC_Surveypage_intro_05TC_Surveypage_Intro_06() {
	  driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtSurveyAdvertise").isDisplayed();
	  driver.findElementById("WellsFargo.Echo.Droid.UI:id/imgPin").isDisplayed();
	  driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtSwipeUp").isDisplayed();
	  driver.findElementById("WellsFargo.Echo.Droid.UI:id/imgSurvey").isDisplayed();
  }
  
//  @Test (priority=29)
//  public void TC_Surveypage_pinsurvey_01() {
//	  //Tap on Pin icon
//	  driver.findElementById("WellsFargo.Echo.Droid.UI:id/imgPin").click();
//  }
  
  @Test (priority=30)
  public void TC_Surveypage_SwipeUp_() throws InterruptedException {  
	  
	  driver.swipe(0,2500,0,600,2000);
	 
	  driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtQuestionCount1").isDisplayed();
	  driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtQuestionTitle").getText().equals("How satisfied are you with the Product?");
	  
  }
  
  @Test (priority=31)
  public void TC_Surveypage_SwipeUp_Question()  { 
	  
	  driver.swipe(0,2000,0,1000,1000);
	 
	  
	  driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtQuestionTitle").getText().equals("Are you satisfied with the service?");
	  driver.findElementById("WellsFargo.Echo.Droid.UI:id/rdgAnswerOptions").isDisplayed();
	  	  
  }
  
  @Test (priority=32)
  public void TC_Surveypage_Swipedown_Question()  { 
	  
	  driver.swipe(0,300,0,2500,1000);
	 
	  driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtQuestionTitle").getText().equals("How satisfied are you with the Product?");
	 	  
  }
  @Test (priority=33)
  public void TC_Surveypage_Submitbutton_enabled_TC_Surveypage_respondtosurvey_01() { 
	  
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/ratingStar").isDisplayed();
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/ratingStar").click();
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/txtSwipeUp").isEnabled();
  }
  
  @Test (priority=34)
  public void TC_Surveypage_pinsurvey_Questionpage() { 
	  
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/imgPin").isDisplayed();
	   driver.findElementById("WellsFargo.Echo.Droid.UI:id/imgPin").click();
	   
  }
 
  
  
  public boolean takeScreenshot(final String name) {
      String screenshotDirectory = System.getProperty("appium.screenshots.dir", System.getProperty("java.io.tmpdir", ""));
      File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      return screenshot.renameTo(new File(screenshotDirectory, String.format("%s.png", name)));
  }
}


