package com.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.pom.utilities.DriverManager;

public class hotelspage extends basePage {

	@FindBy(xpath = "//a[text()=' International  hotels']")
	public WebElement hotel_lbl;

	WebDriver driver;

	public hotelspage() {
		this.driver = DriverManager.getdriver();
	}

	public hotelspage open() {
		
		return (hotelspage) Getpagetoload(hotelspage.class);
			
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(hotel_lbl);
	}
}
