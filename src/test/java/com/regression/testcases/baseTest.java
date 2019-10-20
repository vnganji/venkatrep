package com.regression.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.pom.pages.basePage;
import com.pom.utilities.DriverManager;
import com.pom.utilities.ExcelReader;

public class baseTest  {
	
	public WebDriver driver;
	public FileInputStream FSO=null;
	public String browser="chrome";
	public Properties prop = new Properties();
	public ExpectedCondition exc ;
	public String projDirectory = System.getProperty("user.dir");
	public WebDriverWait wait;
	public final long  ExplicitWait=20;
	public static SoftAssert sassert = new SoftAssert();

	
	
	
	
	public void openbrowser() throws IOException {
		
		System.setProperty("webdriver.chrome.driver",
				"c:\\Users\\ADMIN\\chromedriver_win32_chrome77\\chromedriver.exe");
		FSO = new FileInputStream(projDirectory + "//src//test//resources//Configrations//properties.config");
		prop.load(FSO);
		if (prop.getProperty("Browser").equals("Chrome")) {
		driver = new ChromeDriver();}
		DriverManager.setdriver(driver);
		System.out.println("driver code "+DriverManager.getdriver().hashCode());
		wait = new WebDriverWait(DriverManager.getdriver(),ExplicitWait);
		
		
	}
	
	public void tearDown() {
		
		DriverManager.getdriver().close();
	}

	 
	
	

}
