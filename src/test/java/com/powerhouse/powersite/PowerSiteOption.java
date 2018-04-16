package com.powerhouse.powersite;

import org.testng.annotations.Test;

import com.powerhouse.baseClass.InvokeBrowser;
import com.powerhouse.pageClass.LogInWithUserNameAndPassWord;
import com.powerhouse.pageClass.PowerSite;
import com.powerhouse.propertyClass.Property;
import com.powerhouse.reportClass.ExtentFactory;
import com.powerhouse.screenshotClass.ScreenShot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

public class PowerSiteOption {
	WebDriver driver;
	ExtentTest test;
	ExtentReports report;
	LogInWithUserNameAndPassWord login_with_user_name_and_Password;
	PowerSite power_site;
	String url;
	@BeforeClass
	public void beforeClass() throws IOException {
		report=ExtentFactory.generateReport();
		test=report.startTest("powersiteOption");
		String browserName=Property.readPropertyData("check", "browser");
		driver=InvokeBrowser.openBrowser(browserName);
		url=Property.readPropertyData("check", "URL");
		driver.get(url);
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "browser opened");
		login_with_user_name_and_Password=new LogInWithUserNameAndPassWord(driver, test);
		power_site=new PowerSite(driver, test);
	}

	@Test
	public void powersiteFunctionWith0SiteCreation() throws IOException {
		String userName=Property.readPropertyData("check", "username");
		String passWord=Property.readPropertyData("check", "password");
		login_with_user_name_and_Password.logIn(userName, passWord);
		test.log(LogStatus.INFO, "logged in to the pohostaging");
		power_site.powerSitefunctionInitial();
		test.log(LogStatus.INFO, "perform the power site initial function "
				+ "with zerro powersite subscription");
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
