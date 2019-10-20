package com.pom.utilities;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	
	//private static WebDriver driver;
	
	public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	
	public static void setdriver(WebDriver driver) {
		dr.set(driver);
	}
	
	public static WebDriver getdriver() {
		
		return dr.get();
		
	}
	
	

}
