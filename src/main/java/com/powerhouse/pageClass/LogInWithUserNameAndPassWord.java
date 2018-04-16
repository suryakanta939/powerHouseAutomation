package com.powerhouse.pageClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.powerhouse.commonClass.Waiting;
import com.powerhouse.propertyClass.Property;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LogInWithUserNameAndPassWord {
	
	static WebDriver driver;
	static ExtentTest test;
	static WebElement element;
	static String xpath1="//h2[text()='@";
	static String xpath2="']";
	@FindBy(id="user")
	 WebElement userName;
	
	@FindBy(id="pass")
	WebElement passWord;
	
	@FindBy(id="wp-submit")
	WebElement subMit;
	
	public static WebElement userProfileName(String profileName) throws IOException{
		element=driver.findElement(By.xpath(xpath1+profileName+xpath2));
		return element;
	}
	public LogInWithUserNameAndPassWord(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
/**
 * this function is to log in to the powersite through username and password
 * 
 * 
 * */	
	public  void logIn(String user,String pass) throws IOException{
		userName.sendKeys(user);
		test.log(LogStatus.INFO, "entered the userName");
		passWord.sendKeys(pass);
		test.log(LogStatus.INFO, "entered the password");
		subMit.click();
		test.log(LogStatus.INFO, "clicked on the submit button");
	}

}
