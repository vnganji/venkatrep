package com.pom.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.pom.utilities.DriverManager;

public class homePage extends basePage {

	public static WebDriver driver;

	public homePage() {
		this.driver = DriverManager.getdriver();
	}

	@FindBy(xpath = "//a[@href='/international-flights/']")
	public WebElement flight_tag;

	@FindBy(xpath = "//span[text()='Flights']")
	public WebElement flights_img;
	@FindBy(xpath = "//span[text()='Hotels']")
	public WebElement hotels_img;
	@FindBy(xpath = "//span[text()='Holidays']")
	public WebElement holidays_img;
	@FindBy(xpath = "//span[text()='Trains']")
	public WebElement trains_img;
	@FindBy(xpath = "//span[text()='Buses']")
	public WebElement buses_img;
	@FindBy(xpath = "//span[text()='Cabs']")
	public WebElement cabs_img;
	@FindBy(xpath = "//span[text()='Visa']")
	public WebElement visa_img;
	@FindBy(xpath = "//span[text()='Homes & Villas']")
	public WebElement homeandvillas_img;
	@FindBy(xpath = "//span[text()='Giftcards']")
	public WebElement Giftcards_img;
	@FindBy(xpath = "//span[text()='More']")
	public WebElement More_img;
	@FindBy(xpath = "//input[@id='fromCity']")
	public WebElement flight_fromcity_btn;
	@FindBy(xpath = "//input[@id='toCity']")
	public WebElement flight_tocity_btn;
	@FindBy(xpath = "//input[@placeholder='From']")
	public WebElement flight_fedit_txt;
	@FindBy(xpath = "//input[contains(@class,'react-autosuggest__input react-autosuggest')]")
	public WebElement flight_tedit_txt;
	@FindBy(xpath = "//div[@for='departure']")
	public WebElement departuredate_btn;
	@FindBy(xpath = "//div[for='return']")
	public WebElement returndate_btn;
	@FindBy(xpath = "//li[text()='Round Trip']")
	public WebElement Roundtrip_sel;

	public homePage open(String URL) {

		Reportinfo("Loging into " + URL);
		driver.get(URL);
		driver.manage().window().maximize();
		return (homePage) Getpagetoload(homePage.class);

	}

	/*
	 * public void createflight() throws InterruptedException {
	 * 
	 * 
	 * if (!Roundtrip_sel.isSelected()) Roundtrip_sel.click();
	 * autosuggestivelist("Hyderabad",flight_fromcity_btn,flight_fedit_txt);
	 * System.out.println("Selecting to List");
	 * autosuggestivelist("Mysore",flight_tocity_btn,flight_tedit_txt);
	 * selectcalendate("12-03-2020", departuredate_btn);
	 * selectcalendate("13-06-2020", returndate_btn);
	 * 
	 * }
	 */

	public void checkRoundTrip() {
		if (!Roundtrip_sel.isSelected())
			Roundtrip_sel.click();
		Reportinfo("Round Trip select box selected");
	}

	public void selectflightSource(String Source) throws InterruptedException {
		autosuggestivelist(Source, flight_fromcity_btn, flight_fedit_txt);
		Reportinfo(Source + " city selected as source");
	}

	public void selectflightDest(String Dest) throws InterruptedException {
		autosuggestivelist(Dest, flight_tocity_btn, flight_tedit_txt);
		Reportinfo(Dest + " city selected as Destination");
	}

	public void selectdate(String towardJourney) throws InterruptedException {
		selectcalendate(towardJourney, departuredate_btn);
		Reportinfo(towardJourney + " selected as towardsJourney date");

	}

	public void selectretdate(String returndate) throws InterruptedException {
		selectcalendate(returndate, returndate_btn);
		Reportinfo(returndate + " selected as returnJourney date");
	}

	public void gotoHotel() {
		click(hotels_img, "hotel link");
	}

	public void gotoflight() {
		click(flights_img, "flight link");
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(flight_tag);
	}

}
