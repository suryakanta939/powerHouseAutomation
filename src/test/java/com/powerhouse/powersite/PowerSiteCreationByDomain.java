package com.powerhouse.powersite;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.powerhouse.baseClass.InvokeBrowser;
import com.powerhouse.commonClass.ActionFunctions;
import com.powerhouse.commonClass.Waiting;
import com.powerhouse.pageClass.LogInThroughGoolge;
import com.powerhouse.pageClass.PowerSite;
import com.powerhouse.propertyClass.Property;
import com.powerhouse.reportClass.ExtentFactory;
import com.powerhouse.screenshotClass.ScreenShot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PowerSiteCreationByDomain {
	WebDriver driver;
	ExtentTest test;
	ExtentReports report;
	PowerSite power_site;
	LogInThroughGoolge login_through_google;
	String url;
	
	@BeforeClass
	public void beforeClass() throws IOException {
		report=ExtentFactory.generateReport();
		test=report.startTest("powersite creation by domain");
		String browserName=Property.readPropertyData("check", "browser");
		driver=InvokeBrowser.openBrowser(browserName);
		url=Property.readPropertyData("check", "URL");
		driver.get(url);
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "browser opened");
		login_through_google=new LogInThroughGoolge(driver, test);
		power_site=new PowerSite(driver, test);
		
	}
	
	@Test
	public void ByDomain() throws IOException, InterruptedException {	
		login_through_google.logIn();
		test.log(LogStatus.INFO, "logged in through google");
		power_site.clickOnPowerSite();
		power_site.clickOnTheCreatePowerSite();
		Waiting.waitForTheVisibilty(driver, power_site.createSitePage, 10);
		String title=power_site.createSitePage.getText();
		SoftAssert ass=new SoftAssert();
		ass.assertEquals(title, "Create Site","we are on create site page");
		test.log(LogStatus.INFO, "checked the created site page");
		ass.assertAll();
		power_site.createPowerSiteByDomain();
		
	}
	
	@Test(dependsOnMethods="ByDomain")
	public void checkSiteCreatedOrNot() throws IOException, InterruptedException{
		power_site.isSiteCreatedByDomain();
		test.log(LogStatus.INFO, "site created sucessfully");
	}

	@Test(dependsOnMethods="checkSiteCreatedOrNot")
	public void deleteSite() throws IOException, InterruptedException{
		power_site.deleteSite();
		test.log(LogStatus.INFO, "created site delted sucessfully");
        Thread.sleep(3000);
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
