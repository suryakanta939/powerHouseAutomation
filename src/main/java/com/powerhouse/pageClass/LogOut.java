package com.powerhouse.pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.powerhouse.commonClass.Waiting;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LogOut {
	
	static WebDriver driver;
	static ExtentTest test;
	
	@FindBy(xpath="//i[@class='fa fa-sign-out']")
	WebElement logout;
	
	@FindBy(xpath="//p[text()='You are logged out.']")
	WebElement logOutMessage;
	
	public LogOut(WebDriver driver ,ExtentTest test){
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	public void logOutFromPowserHouse(){
		
		Waiting.waitForTheVisibilty(driver, logout, 10);
		logout.click();
		test.log(LogStatus.INFO, "clciked on the logout button");
		Waiting.waitForTheVisibilty(driver, logOutMessage, 10);
		String message=logOutMessage.getText();
		test.log(LogStatus.INFO, "reading the logout message");
		if(message.equals("You are logged out.")){
			System.out.println("sucessfully logged ot from the site");
		}
	}

}
