package com.pom.utilities;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;

import com.aventstack.extentreports.ExtentTest;
import com.pom.ExtentReports.ExtentListeners;


public class Resusables {

	public static WebDriver driver;
	public static ExtentTest report;

	public enum Months {
		January(1), February(2), March(3), April(4), May(5), June(6), July(7), August(8), September(9), October(10),
		November(11), December(12);
		private int value;

		private Months(int value) {
			this.value = value;
		}
	}
	
	public static void Reportinfo(String message) {
		
		ExtentListeners.testReport.get().info(message);
	
	}

	public static void autosuggestivelist(String val, WebElement... elem) throws InterruptedException {

		try {
			driver = DriverManager.getdriver();
			Actions act = new Actions(driver);
			act.moveToElement(elem[0]).click().build().perform();
			elem[1].click();
			elem[1].sendKeys(val);
			elem[1].sendKeys(Keys.ARROW_DOWN);
			elem[1].sendKeys(Keys.ENTER);

		} catch (Throwable T) {
			T.printStackTrace();
		}

	}
	
	public static void click(WebElement Elem, String Elemname) {
		try {
			Elem.click();
			Reportinfo("Clicking Button "+Elemname);
			}catch(Throwable T) {T.printStackTrace();}
	}
	
	public static void type(WebElement Elem, String value, String Elemname) {
		try {
			Elem.sendKeys(value);
			Reportinfo("Keyed value "+value+" in field "+Elemname);
			
			}catch(Throwable T) {T.printStackTrace();}
	}

	public void selectcalendate(String date, WebElement elem) throws InterruptedException {

		driver = DriverManager.getdriver();
		String monthname = null;
		String[] datesplit = date.contains("/") ? date.split("/") : date.split("-");
		int i = Integer.parseInt(datesplit[1]);
		for (Months m : Months.values())
			if (m.value == i) {
				monthname = m.name();
				break;
			}

		String calendartext = monthname + " " + datesplit[2];
		String calendardate = monthname.substring(1, 3) + " " + datesplit[0];
		System.out.println(calendartext);

		boolean IsPresent = driver
				.findElements(By.xpath("//div[text()='" + monthname + "']//span[text()='" + datesplit[2] + "']"))
				.size() <= 0;
		while (IsPresent) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			IsPresent = driver
					.findElements(By.xpath("//div[text()='" + monthname + "']//span[text()='" + datesplit[2] + "']"))
					.size() <= 0;
		}
		driver.findElement(By.xpath("//div[contains(@aria-label,'" + calendardate + "')]")).click();

	}

}
