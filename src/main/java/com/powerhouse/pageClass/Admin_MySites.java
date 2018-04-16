package com.powerhouse.pageClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.powerhouse.commonClass.ActionFunctions;
import com.powerhouse.commonClass.HandelWindow;
import com.powerhouse.commonClass.Waiting;
import com.powerhouse.propertyClass.Property;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Admin_MySites {
	
	WebElement element;
	WebDriver driver;
	ExtentTest test;
	String siteNamexpath1="//td[p[text()='";
	String siteNamexpath2="']]//a[text()='Delete']";
	
	@FindBy(xpath="//*[@id='wp-admin-bar-mod_dwb']/a")
	WebElement adminDashBoard;
	
	@FindBy(xpath="//h3[text()='My Sites']")
	WebElement mySites;
	
	 @FindBy(id="delete_network")
	 WebElement deleteNetWork;
	 
	public WebElement siteToBeDeleted() throws IOException{
		String powerSiteName=Property.readPropertyData("powersite", "powersiteNameToBeDeleted");
		element=driver.findElement(By.xpath(siteNamexpath1+powerSiteName+siteNamexpath2));
		return element;
	}
	
	public Admin_MySites(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Bellow are the elements for deletion of site
	 * @throws IOException 
	 * 
	 * */
	
	public void openAdminDashBoardInAnotherTab() throws IOException{
		String browser=Property.readPropertyData("check", "browser");
		if(browser.equals("firefox")){
			ActionFunctions.mouseHoverOnElement(driver, adminDashBoard);
			ActionFunctions.openLinkInAnotherTab(driver, adminDashBoard);
			test.log(LogStatus.INFO, "admin dash board is opened in another tab");
			ActionFunctions.moveToTab(driver);
			test.log(LogStatus.INFO, "moved to the mysite page");
			HandelWindow.handelWindowByNo(driver, 1);
		}
		
		if(browser.equals("chrome")){
			ActionFunctions.openEmeptyTab(driver);
			driver.navigate().to("https://app.pohostaging.com/wp-admin/");
		}
	
	}
	
	public void deleteSite() throws IOException, InterruptedException{
		
		openAdminDashBoardInAnotherTab();
		mySites.click();
		test.log(LogStatus.INFO, "clicked on the mysites");
		siteToBeDeleted().click();
		test.log(LogStatus.INFO, "clicked on the desired site to be deleted");
		deleteNetWork.click();
		test.log(LogStatus.INFO, "clicked on the delete network");
		Thread.sleep(3000);
		String browser=Property.readPropertyData("check", "browser");
		if(browser.equals("firefox")){
			ActionFunctions.moveToTab(driver);
			test.log(LogStatus.INFO, "moved to the mysite page");
			HandelWindow.handelWindowByNo(driver, 1);
		}
		if(browser.equals("chrome")){
			while(true){
			try{
				Waiting.waitForTheVisibilty(driver, PowerSite.siteTypeDomain,3);
				break;
			}catch(Throwable t){
				driver.navigate().back();
			}
			
			}
		}
		
	}

}
