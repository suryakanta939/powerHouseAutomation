package com.powerhouse.powersite;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.powerhouse.baseClass.InvokeBrowser;
import com.powerhouse.baseClass.InvokeBrowserStack;
import com.powerhouse.commonClass.Waiting;
import com.powerhouse.pageClass.LogInThroughGoolge;
import com.powerhouse.pageClass.LogInWithUserNameAndPassWord;
import com.powerhouse.pageClass.PowerSite;
import com.powerhouse.pageClass.payment.Cart;
import com.powerhouse.pageClass.payment.CheckOut;
import com.powerhouse.pageClass.subScription.powersiteSubScription;
import com.powerhouse.propertyClass.Property;
import com.powerhouse.reportClass.ExtentFactory;
import com.powerhouse.screenshotClass.ScreenShot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PowerSiteSubscription {
	WebDriver driver;
	ExtentTest test;
	ExtentReports report;
	PowerSite power_site;
	LogInWithUserNameAndPassWord login_with_user_pass;
	String url;
	powersiteSubScription powersite_subscription;
	Cart cart;
	CheckOut checkout;

	@BeforeClass
	public void beforeClass() throws IOException {
		report=ExtentFactory.generateReport();
		test=report.startTest("purchasing subscription");
		String browserName=Property.readPropertyData("check", "browser");
	driver=InvokeBrowser.openBrowser(browserName);
	//	driver=InvokeBrowserStack.runInBrowserStack();
		url=Property.readPropertyData("check", "URL");
		driver.get(url);
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "browser opened");
		login_with_user_pass=new LogInWithUserNameAndPassWord(driver, test);
		power_site=new PowerSite(driver, test);
		powersite_subscription=new powersiteSubScription(driver, test);
		cart=new Cart(driver, test);
		checkout=new CheckOut(driver, test);
	}

	@Test
	public void purchageStartupPlan() throws IOException, InterruptedException {
		String userName=Property.readPropertyData("mailandlytics", "username");
		String passWord=Property.readPropertyData("mailandlytics", "password");
		login_with_user_pass.logIn(userName, passWord);
       Thread.sleep(3000);
		powersite_subscription.suscribeStartUpPlan();
		Waiting.implictyWait(driver, 10);
		cart.clickOnProceedToCheckOut();
		//checkout.checkingOutProduct();
		checkout.checkingOutProductNewZland();
		
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
