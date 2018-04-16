package com.powerhouse.baseClass;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InvokeBrowser {
	
	public static WebDriver driver;
	
	public static WebDriver openBrowser(String browserName){
		
		if(browserName.equalsIgnoreCase("firefox")){
//			File f=new File("Drivers");
//			File fs=new File(f,"geckodriver.exe");
//			System.out.println(fs.getAbsolutePath());
//		System.setProperty("webdriver.gecko.driver", fs.getAbsolutePath());
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome")){
			File f=new File("Drivers");
			File fs=new File(f,"chromedriver.exe");
			System.out.println(fs.getAbsolutePath());
			System.setProperty("webdriver.chrome.driver", fs.getAbsolutePath());
			driver=new ChromeDriver();
		}
		return driver;
	}

}
