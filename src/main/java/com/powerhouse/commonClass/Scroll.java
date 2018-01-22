package com.powerhouse.commonClass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Scroll {

	/**
	 * This function is to scrll up to 250 pixel
	 * */
	public static void scrollUp(WebDriver driver){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-250)", "");
	}
	
	/**
	 * This function is to scrll down to 250 pixel
	 * */
	public static void scrollDown(WebDriver driver){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
	}
	
	/**
	 * This function is to scroll exact to the element
	 * */
	
	public static void scrollToExactElement(WebDriver driver,WebElement element){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",element);
	}
}
