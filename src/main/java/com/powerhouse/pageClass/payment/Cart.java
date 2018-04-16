package com.powerhouse.pageClass.payment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.powerhouse.commonClass.Scroll;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Cart {
   
	WebDriver driver;
	ExtentTest test;
	
	@FindBy(xpath="//h1[text()='Cart']")
	WebElement cart;
	
	@FindBy(xpath="//a[contains(text(),'Proceed to checkout')]")
	WebElement proceedtoCheckOut;
	
	public Cart(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnProceedToCheckOut(){
		String actualtext=cart.getText();
		System.out.println(actualtext);
			Scroll.scrollToExactElement(driver, proceedtoCheckOut);
			test.log(LogStatus.INFO, "now we are on home page");
			proceedtoCheckOut.click();
			test.log(LogStatus.INFO, "clicked on th eproceed to checkout");
		}
	}

