package com.powerhouse.propertyClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Property {
     
	/**
	 * This function is to read the property file
	 * */
	public static String readPropertyData(String key) throws IOException{
		File f=new File("PropertyFiles");
		File fs=new File(f,"check.properties");
		System.out.println(fs.getAbsolutePath());
		FileInputStream fis=new FileInputStream(fs.getAbsolutePath());
		Properties pro=new Properties();
		pro.load(fis);
		String value=pro.getProperty(key);
		return value;
		
	}
}
