package com.regression.testcases;

import java.io.FileInputStream;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.pom.utilities.Constants;
import com.pom.utilities.DriverManager;

public class rough {
system.out.println("changes");
	public static WebDriver driver;
	public static void main(String[] args) {
		/*System.setProperty("webdriver.chrome.driver",
				"c:\\Users\\ADMIN\\chromedriver_win32_chrome77\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://bing.com");
		driver.manage().window().maximize();*/
		/*WebElement elem = driver.findElement(By.xpath("//div[@id='hp_sw_hdr']"));
		List<WebElement> hlinks = elem.findElements(By.tagName("a"));
		for (int i = 0; i<hlinks.size();i++)
			System.out.println(hlinks.get(i).getText());
		Iterator<WebElement> itr= hlinks.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().getText());
		}*/
		
		System.setProperty("webdriver.chrome.driver",
				"c:\\Users\\ADMIN\\chromedriver_win32_chrome77\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://amazon.com");
		driver.manage().window().maximize();
		Select sel = new Select(driver.findElement(By.
				xpath("//select[@class='nav-search-dropdown searchSelect']")));
		sel.selectByIndex(2);
		List<WebElement> cats = sel.getOptions();
		 for(WebElement cat: cats) {
			if (cat.getText().equals("Electronics"))
				sel.selectByVisibleText("Electronics");
		 }
		

}}
