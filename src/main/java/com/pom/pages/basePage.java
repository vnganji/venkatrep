package com.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.pom.utilities.DriverManager;
import com.pom.utilities.Resusables;

public abstract class basePage extends Resusables {

	protected WebDriver driver;
	public SoftAssert sassert = new SoftAssert();

	public <T> T Getpagetoload(Class<T> cls) {

		driver = DriverManager.getdriver();
		T page = null;
		AjaxElementLocatorFactory ajax = new AjaxElementLocatorFactory(driver, 10);
		page = PageFactory.initElements(driver, cls);
		PageFactory.initElements(ajax, page);
		try {			
		ExpectedCondition pageLoadCondition = ((basePage) page).getPageLoadCondition();
		waitforpagecondition(pageLoadCondition);
		}catch(Throwable t) {
			System.out.println(cls.getSimpleName()+" page not found");
			page=null;
			}
		System.out.println("not found "+page);
		return page;

	}

	protected abstract ExpectedCondition getPageLoadCondition();

	public void waitforpagecondition(ExpectedCondition Ex) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(Ex);

	}

}
