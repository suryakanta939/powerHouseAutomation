package com.powerhouse.commonClass;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionFunctions {
	/**
	 * This function is to perform the hover on element
	 * */
	public static void mouseHoverOnElement(WebDriver driver,WebElement element){
		Actions act=new Actions(driver);
		act.moveToElement(element).build().perform();
	}
	
	/**
	 * this function is to handle the exception other element is taking the click
	 * at some point
	 * 
	 * This is also to move the coordinate of the element
	 * */
	
	public static void moveToCordinateOfElement(WebDriver driver,WebElement element){
		Actions act=new Actions(driver);
		int xCord=element.getLocation().getX();
		int yCord=element.getLocation().getY();
		act.moveToElement(element, xCord, yCord).build().perform();
	}
	
	/**
	 * 
	 * Use this function for the drag and drop
	 * */
	
	public static void DragAndDrop(WebDriver driver,WebElement srcElement,WebElement dstElement){
		Actions act=new Actions(driver);
		act.clickAndHold(srcElement).moveToElement(dstElement).release().perform();
	}
	
	/**
	 * This function is to open a link in another tab
	 * */
      public static void openLinkInAnotherTab(WebDriver driver,WebElement element){
    	  Actions act=new Actions(driver);
    	  act.contextClick(element).sendKeys("t").perform();
      }
      
      /**
       * This function is to move to another tab
       * 
       * */
      
      public static void moveToTab(WebDriver driver){
    	  Actions act=new Actions(driver);
         act.sendKeys(Keys.chord(Keys.SHIFT,Keys.TAB)).build().perform();
   
      }
      
      /**
       * This function is to open a empty  tab
       * */
      public static void openEmeptyTab(WebDriver driver){
    	  Actions act=new Actions(driver);
    	  act.sendKeys(Keys.chord(Keys.CONTROL,"t")).build().perform();
      }
}
