package com.powerhouse.screenshotClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ScreenShot {
	/**
	 * This function is to take a screen shot
	 * when ever a test case will fail this will help to take a screen shot
	 * 
	 * */
	
	public static String takeScreenShot(WebDriver driver,String fileName) throws IOException{
		File f=new File("AllImages");
		File fs=new File(f,"");
		EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
		File srcFile=eDriver.getScreenshotAs(OutputType.FILE);
		File dstFile=new File(fs.getAbsolutePath()+"\\"+fileName+".png");
		FileUtils.copyFile(srcFile, dstFile);
		String imagePath=fs.getAbsolutePath()+"\\"+fileName+".png";
		System.out.println(imagePath);
		return imagePath;
	}

}
