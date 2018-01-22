package com.powerhouse.commonClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HandelFrame {

	/**
	 * This function is to handle the frame by its index
	 * 
	 * */
	public static void handelFrameByIndex(WebDriver driver,int no){
		driver.switchTo().frame(no);
	}

	/**
	 * This function is to handle the frame by its text
	 * 
	 * */
	
	public static void handelFrameByText(WebDriver driver,String text){
		driver.switchTo().frame(text);
	}
	

	/**
	 * This function is to handle the frame by its web element
	 * 
	 * */
	
	public static void handelWindowByXpath(WebDriver driver,WebElement frameElement){
		driver.switchTo().frame(frameElement);
	}
	

	/**
	 * This function is to get the control back to the main window
	 * 
	 * */
	public static void controlBackToWindow(WebDriver driver){
		driver.switchTo().defaultContent();
	}
}
