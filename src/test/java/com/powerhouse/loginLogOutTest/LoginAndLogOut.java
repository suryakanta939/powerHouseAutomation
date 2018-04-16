package com.powerhouse.loginLogOutTest;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.powerhouse.baseClass.InvokeBrowser;
import com.powerhouse.baseClass.InvokeBrowserStack;
import com.powerhouse.commonClass.HandelAlert;
import com.powerhouse.commonClass.Waiting;
import com.powerhouse.pageClass.LogInThroughFaceBook;
import com.powerhouse.pageClass.LogInThroughGoolge;
import com.powerhouse.pageClass.LogOut;
import com.powerhouse.propertyClass.Property;
import com.powerhouse.reportClass.ExtentFactory;
import com.powerhouse.screenshotClass.ScreenShot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginAndLogOut {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	 String browser;
	   String url;
	   LogInThroughFaceBook lf;
	   LogInThroughGoolge lg;
	   LogOut lo;
	@BeforeClass
	public void setUp() throws IOException{
		report=ExtentFactory.generateReport();
		test=report.startTest("checking the loginTest");
		  browser=Property.readPropertyData("check","browser");
		    url=Property.readPropertyData("check","URL");
		    driver=InvokeBrowserStack.runInBrowserStack();
		    test.log(LogStatus.INFO, "browser"+browser+" is invoked");
		    
		    // initializing the functions
		    
			  lf=new LogInThroughFaceBook(driver, test);
			  lg=new LogInThroughGoolge(driver, test);
			  lo=new LogOut(driver, test);
			  driver.get(url);
			  driver.manage().window().maximize();
	}
	
  @Test
  public void logInWithFaceBook() throws IOException {
	  lf.logIn();
	  test.log(LogStatus.INFO, "sucessFully logged in to the powehouse through the facebook");
	  
	  
  }
  
  @Test(dependsOnMethods="logInWithFaceBook")
  public void logInWithGoogle() throws IOException, InterruptedException {
	  lg.logIn();
	  test.log(LogStatus.INFO, "sucessFully logged in to the powerhouse through the google");
	 

  }
  
  @AfterMethod
  public void exeCutingAfterMethod(ITestResult result) throws IOException, InterruptedException{
	  lo.logOutFromPowserHouse();
		  if(result.getStatus()==result.SUCCESS){
			  test.log(LogStatus.PASS, "test case got pass");
		  }
		  else if(result.getStatus()==result.SKIP){
			  test.log(LogStatus.SKIP, "test case got skipped");
		  }
		  else if(result.getStatus()==result.FAILURE){
			  String path=ScreenShot.takeScreenShot(driver, result.getName());
			  test.log(LogStatus.FAIL, "test case got fail", test.addScreenCapture(path));
		  }
	
	  
	  
  }
  
  @AfterClass
  public void tearDown(){
	  driver.quit();
	  test.assignAuthor("suryakanta");
	  report.endTest(test);
	  report.flush();
	  
  }
  
}
