package com.powerhouse.reportClass;


import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	static ExtentReports report;
	
	/**
	 * This function is  to generate advance report
	 * 
	 * */
	
	public static ExtentReports generateReport(){
		File f=new File("Reports");
		File fs=new File(f,"");
		return report=new ExtentReports(fs.getAbsolutePath()+"\\powerhouse.html",false);
	}

}
