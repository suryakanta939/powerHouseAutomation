package com.powerhouse.commonClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiting {
	
	/**
	 * This function is to wait for the element until its visible
	 * 
	 * */
	
	public static void waitForTheVisibilty(WebDriver driver,WebElement element,int timeInsec){
		 WebDriverWait wait=new WebDriverWait(driver,timeInsec);
				 wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This function will wait for the element until its clicked 
	 * it will wait for to perform the click up to the given time
	 * */
	
	public static void waitelementToBeclcikAble(WebDriver driver,WebElement element,int timeInsec){
		WebDriverWait wait=new WebDriverWait(driver,timeInsec);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This function will wait for the element until its selected 
	 * it will wait for to perform the click up to the given time
	 * */

	public static void waitElementTobeSelected(WebDriver driver,WebElement element,int timeInsec){
		WebDriverWait wait=new WebDriverWait(driver,timeInsec);
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	/**
	 * This function is to wait for the alert
	 * 
	 * */
	public static void waitForAlert(WebDriver driver,int timeInsec){
		WebDriverWait wait=new WebDriverWait(driver,timeInsec);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	/**
	 * this function will wait for specific time
	 * */
	public static void implictyWait(WebDriver driver,int timeInsec){
		driver.manage().timeouts().implicitlyWait(timeInsec, TimeUnit.SECONDS);
	}
}
