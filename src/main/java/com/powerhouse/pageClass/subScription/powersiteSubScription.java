package com.powerhouse.pageClass.subScription;

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

public class powersiteSubScription {
   
	static WebDriver driver;
	ExtentTest test;
	static WebElement element;
	static String xpathaddtocart1="//*[@id='no-of-powersites']/ul/li[";
	static String xpathaddtocart2="]/a[2]";	
			
	@FindBy(xpath="//a[text()='PowerHouse Services']")
	WebElement powerhouseService;
	
	@FindBy(xpath="//a[text()='PowerSites']")
	WebElement powersite;
	
	@FindBy(xpath="//h1[text()='Subscriptions']")
	WebElement subsciptionPage;
	
	
	@FindBy(xpath="//a[text()='View cart']")
	WebElement viewCart;
	
	private static WebElement addToCart_StartUpPlan(String plan) throws IOException{
		String value=Property.readPropertyData("subscription", plan);
		element=driver.findElement(By.xpath(xpathaddtocart1+value+xpathaddtocart2));
		return element;
	}
	
	
	public powersiteSubScription(WebDriver driver,ExtentTest test){
		this.driver=driver;
	    this.test=test;
	    PageFactory.initElements(driver,this);
	}
	
	public  void suscribeStartUpPlan() throws IOException, InterruptedException{
		Waiting.waitForTheVisibilty(driver, powerhouseService, 10);
	   // ActionFunctions.mouseHoverOnElement(driver, powerhouseService);
	    ActionFunctions.moveToCordinateandpermmouseHover(driver, powerhouseService);
	    test.log(LogStatus.INFO, "sucessfully mouse hover on powerhouseService");
	    Waiting.waitForTheVisibilty(driver, powersite, 10);
	    powersite.click();
	    HandelWindow.handelWindowByNo(driver, 2);
	    test.log(LogStatus.INFO, "cliked on the powersite");
	    	 addToCart_StartUpPlan("startup").click();
	    	 test.log(LogStatus.INFO, "clicked on the add to cart");
	    	 Waiting.waitForTheVisibilty(driver, viewCart, 10);
	    	 viewCart.click();
	    	test.log(LogStatus.INFO,"cliked on view cart");
	   
	}
}
