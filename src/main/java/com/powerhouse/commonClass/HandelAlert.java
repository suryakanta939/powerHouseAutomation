package com.powerhouse.commonClass;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class HandelAlert {

	/**
	 * This function is to acceptThe Alert
	 * */
	
	public static void acceptAlert(WebDriver driver){
		Alert alt=driver.switchTo().alert();
		alt.accept();
	}
	
	/**
	 * This function is cancel the alert
	 * */
	public static void cancelAlert(WebDriver driver){
		Alert alt=driver.switchTo().alert();
		alt.dismiss();
	}
	/**
	 * This function is to read the text from the alert
	 * */
	public static String readTextFromAlert(WebDriver driver){
		Alert alt=driver.switchTo().alert();
		String text=alt.getText();
		return text;
	}
	
	public static void handelUnexpectedAlert(WebDriver driver) throws InterruptedException{
		int count=0;
		while(count <=5){
			
			try{
				acceptAlert(driver);
			}catch(Throwable t){
				count++;
				Thread.sleep(10);
			}
		}
	}
}
