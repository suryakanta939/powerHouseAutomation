package com.powerhouse.baseClass;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.powerhouse.propertyClass.Property;


public class InvokeBrowserStack {
     public static WebDriver driver;
     public static final String USERNAME = "davidding2";
	  public static final String AUTOMATE_KEY = "jT7ix3GsnYAnApd1RdNy";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
     
	public static WebDriver runInBrowserStack() throws IOException{
		  String browserName=Property.readPropertyData("check", "browser");
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("browser", "Chrome");
		 if(browserName.equals("firefox")){
			 String version=Property.readPropertyData("browserstack", "browserVersionFFX");
			 caps.setCapability("browser_version", version);
		 }else if (browserName.equals("chrome")) {
			 String version=Property.readPropertyData("browserstack", "browserVersionChrome");
			 caps.setCapability("browser_version", version);
		}
		    caps.setCapability("os", "Windows");
		    caps.setCapability("os_version", "10");
		    caps.setCapability("resolution", "1024x768");
		    driver = new RemoteWebDriver(new URL(URL), caps);
		    return driver;
	}

	   
}
