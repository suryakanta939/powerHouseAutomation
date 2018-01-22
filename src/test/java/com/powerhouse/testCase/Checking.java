package com.powerhouse.testCase;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.powerhouse.baseClass.InvokeBrowser;
import com.powerhouse.propertyClass.Property;



public class Checking {
	WebDriver driver;
	
  @Test
  public void f() throws IOException {
	  String browser=Property.readPropertyData("browser");
	   String url=Property.readPropertyData("URL");
	  driver=InvokeBrowser.opwnBrowser(browser);
	  driver.get(url);
	  driver.manage().window().maximize();
	
  }
}
