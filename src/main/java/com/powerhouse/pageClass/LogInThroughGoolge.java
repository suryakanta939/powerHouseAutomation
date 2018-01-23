package com.powerhouse.pageClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.powerhouse.commonClass.HandelAlert;
import com.powerhouse.commonClass.Waiting;
import com.powerhouse.propertyClass.Property;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LogInThroughGoolge {

	/**
	 * Initializing and storing the web elements
	 * */
	static WebDriver driver;
	static ExtentTest test;
	static WebElement element;
	
	@FindBy(xpath="//a[@class='btn btn-default glogin-btn']")
	WebElement loginButton;
	
	@FindBy(xpath="//input[@type='email']")
	WebElement email;
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement next;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//h1[text()='suryakanta']")
	WebElement name;
	
	public LogInThroughGoolge(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * this function is to login to google
	 * @throws InterruptedException 
	 *
	 * */
	
	 public void logIn() throws IOException, InterruptedException{
		 loginButton.click();
		 test.log(LogStatus.INFO, "clciked  on the google login button");
		 
		 HandelAlert.handelUnexpectedAlert(driver);
		 test.log(LogStatus.INFO, "handeling unexpected alert");
		 Waiting.waitForTheVisibilty(driver, email, 10);
		 
		 //getting the user name
		 String userName=Property.readPropertyData("googleUserName");
		 
		 email.sendKeys(userName);
		 test.log(LogStatus.INFO, "entered the user name");
		 next.click();
		 test.log(LogStatus.INFO, "clciked on the next button");
		 Waiting.waitForTheVisibilty(driver, password, 10);
		 
		 //getting the password
		 String passWord=Property.readPropertyData("googlePassWord");
		 password.sendKeys(passWord);
		 test.log(LogStatus.INFO, "entered the passWord");
		 next.click();
		 test.log(LogStatus.INFO, "clciked on the next button");
		 Waiting.waitForTheVisibilty(driver, name, 10);
		 String Myname=name.getText();
		 test.log(LogStatus.INFO, "reading the text");
		 if(Myname.equals("suryakanta")){
			 System.out.println("you are in home page");
		 }
		 
	 }
	
}
