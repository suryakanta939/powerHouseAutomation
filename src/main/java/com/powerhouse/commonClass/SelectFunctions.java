package com.powerhouse.commonClass;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectFunctions {
 static int count=0;
 static String Actuatext;
	/**
	 * this function is to select the elemnet by its visible text
	 * */
	
	public static void selectByText(WebElement element,String text){
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * this function is to select the elemnet by its value
	 * */
	public static void selectByValue(WebElement element,String value){
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * this function is to select the elemnt by its index
	 * */
	public static void selectByindex(WebElement element,int index){
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	public  static void duplicate(WebElement element,String desiredText){
		Select sel=new Select(element);
		List<WebElement> alloptions=sel.getOptions();
		for(int i=0;i<alloptions.size();i++){
			 Actuatext=alloptions.get(i).getText();
			if(Actuatext.equals(desiredText)){
	      	count++;
			}
		}
		if(count >1){
			System.out.println("the duplicate element is "+Actuatext);
		}
	}
	
	
}
