package com.powerhouse.pageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.powerhouse.commonClass.ActionFunctions;
import com.powerhouse.commonClass.Waiting;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MailAndLytics {
	
	static WebDriver driver;
	ExtentTest test;
	boolean displaylogo;
	int time=0;
	@FindBy(xpath="//ul[@id='main-menu']//li[1]/a[text()='Dashboard']")
	WebElement dashboard;
	
	@FindBy(xpath="//a[text()='Admin Dashboard']")
	WebElement adminDashboard;
	
	@FindBy(xpath="//h3[text()='Powermail']")
	WebElement powermail;
	
	@FindBy(xpath="//h3[text()='Powerlytics']")
	WebElement powerLytics;
	
	@FindBy(xpath="//*[@id='web-logo-custom']/img")
	WebElement powerLyticsLogo;
	
	@FindBy(xpath="//a[text()='Back To Admin Dashboard']")
	WebElement backtodashboardPowerLytic;
	
	@FindBy(xpath="//*[@id='login_container']/div/div/img")
	WebElement powermailLogo;
	
	public static WebElement signInDashBoardLytics(){
		WebElement element=driver.findElement(By.xpath("//h1[text()='Sign in to your dashboards']"));
		return element;
	}
	
	
	public MailAndLytics(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}

	public void landinOnAdminDashBoard() throws InterruptedException{
		Waiting.waitForTheVisibilty(driver, dashboard, 10);
		ActionFunctions.moveToCordinateandpermmouseHover(driver, dashboard);
		test.log(LogStatus.INFO, "mouse hover on dashboard");
		adminDashboard.click();
		test.log(LogStatus.INFO, "clicked on admin dashboard");
		
	}
	/**
	 * this function is to check 
	 * weather the lyitcs logo is displaying or not
	 * */
	public boolean isLyticssignboardDisplaying(){
		if(signInDashBoardLytics().isDisplayed()==true){
			displaylogo=true;
		}else{
			displaylogo=false;
		}
		return displaylogo;
	}
	/**
	 * this function is to check 
	 * weather the mail logo is displaying or not
	 * */
	public boolean isMailLogoDisplaying(){
		if(powermailLogo.isEnabled()==true){
			displaylogo=true;
		}else{
			displaylogo=false;
		}
		return displaylogo;
	}
	
	public void checkingLyticsAutoLogin() throws InterruptedException{
		landinOnAdminDashBoard();
		Waiting.waitForTheVisibilty(driver, powerLytics, 10);
		powerLytics.click();
		test.log(LogStatus.INFO, "clicked on powerlytics");
		Waiting.waitForTheVisibilty(driver, powerLyticsLogo, 40);
		backtodashboardPowerLytic.click();
		test.log(LogStatus.INFO, "clicked on the back to admin dashboard");
	}
	
	public void checkingMailAutoLogin() throws InterruptedException{
		powermail.click();
		test.log(LogStatus.INFO, "clicked on powermail");
		while(time<11){
			try{
				System.out.println("mail log displaying: "+isMailLogoDisplaying());
				break;
			}catch(Throwable t){
				Thread.sleep(3000);
				time++;
			}
		}
		
	}
}
