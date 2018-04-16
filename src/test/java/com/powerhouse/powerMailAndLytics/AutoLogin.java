package com.powerhouse.powerMailAndLytics;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.powerhouse.baseClass.InvokeBrowser;
import com.powerhouse.pageClass.LogInWithUserNameAndPassWord;
import com.powerhouse.pageClass.MailAndLytics;
import com.powerhouse.pageClass.PowerSite;
import com.powerhouse.propertyClass.Property;
import com.powerhouse.reportClass.ExtentFactory;
import com.powerhouse.screenshotClass.ScreenShot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AutoLogin {

	WebDriver driver;
	ExtentTest test;
	ExtentReports report;
	PowerSite power_site;
	LogInWithUserNameAndPassWord login_with_user_pass;
	MailAndLytics  mailandlytics;
	String url;
	int time=0;
	@BeforeClass
	public void beforeClass() throws IOException {
		report=ExtentFactory.generateReport();
		test=report.startTest("checkingAutoLogin");
		String browserName=Property.readPropertyData("check", "browser");
		driver=InvokeBrowser.openBrowser(browserName);
		url=Property.readPropertyData("check", "URL");
		driver.get(url);
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "browser opened");
		login_with_user_pass=new LogInWithUserNameAndPassWord(driver, test);
		mailandlytics=new MailAndLytics(driver, test);
	}
	@Test()
	public void powerLytic() throws IOException, InterruptedException {
		String userName=Property.readPropertyData("mailandlytics", "username");
		String passWord=Property.readPropertyData("mailandlytics", "password");
		login_with_user_pass.logIn(userName, passWord);
		mailandlytics.checkingLyticsAutoLogin();
	}
	
	@Test()
	public void powerMail() throws InterruptedException{
		try{
			if(mailandlytics.isLyticssignboardDisplaying()==true){
				for(int i=0;i<1;i++){
					driver.navigate().back();
				}
			}	
		}
		catch(Throwable t){
			
		}
		mailandlytics.checkingMailAutoLogin();
		Assert.assertEquals(false,mailandlytics.isMailLogoDisplaying());
		test.log(LogStatus.INFO, "automatic logged in to powermail");
		
	}
	
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException{
		if(result.getStatus()==result.SUCCESS){
			test.log(LogStatus.PASS, "Test case got pass");
		}
		if(result.getStatus()==result.SKIP){
			test.log(LogStatus.SKIP, "test case got skipped");
		}
		if(result.getStatus()==result.FAILURE){
			String path=ScreenShot.takeScreenShot(driver, result.getName());
			test.log(LogStatus.FAIL, "test case got fail",test.addScreenCapture(path));
		}

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
		test.assignAuthor("suryakanta sahoo");
		report.endTest(test);
		report.flush();
	}

}
