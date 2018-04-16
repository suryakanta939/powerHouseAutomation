package com.powerhouse.pageClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.powerhouse.commonClass.Waiting;
import com.powerhouse.propertyClass.Property;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LogInThroughFaceBook {

	static WebDriver driver;
	static ExtentTest test;
	
	@FindBy(xpath="//a[@class='btn btn-default facebook-btn']")
	WebElement faceBook;
	
	@FindBy(id="email")
	WebElement faceBookEmail;
	
	@FindBy(name="pass")
	WebElement faceBookPassWord;
	
	@FindBy(id="loginbutton")
	WebElement logInButton;
	
	@FindBy(xpath="//h1[text()='suryakanta_sahoo']")
	WebElement name;
	
	@FindBy(xpath="//span[text()='Log in to Facebook']")
	WebElement message;
	
	public LogInThroughFaceBook(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	public void logIn() throws IOException{
		faceBook.click();
		test.log(LogStatus.INFO, "clciked on the facebook");
		Waiting.waitForTheVisibilty(driver, message, 10);
		
		//getting facebook userName
		
		String userName=Property.readPropertyData("check","faceBookUserName");
		faceBookEmail.sendKeys(userName);
		test.log(LogStatus.INFO, "entered the userName");
		//getting the faceBook PAssword
		
		String passWord=Property.readPropertyData("check","faceBookPassWord");
		faceBookPassWord.sendKeys(passWord);
		test.log(LogStatus.INFO, "entered the password");
		logInButton.click();
		
		String Myname=name.getText();
		test.log(LogStatus.INFO, "reading the text");
		if(Myname.equals("suryakanta_sahoo")){
			System.out.println("we are in home page");
		}
		
	}
	
	
}
