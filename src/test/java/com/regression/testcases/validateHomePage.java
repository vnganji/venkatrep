package com.regression.testcases;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pom.pages.homePage;
import com.pom.pages.hotelspage;
import com.pom.pages.basePage;
import com.pom.utilities.Constants;
import com.pom.utilities.metadata;
import com.pom.utilities.DataUtil;
import com.pom.utilities.DriverManager;
import com.pom.utilities.Resusables;

public class validateHomePage extends baseTest {

	public validateHomePage() {

	}

	@metadata(filepath = "", testcasesheet = "", testdatasheet = "")
	@BeforeTest
	public void beforetest() throws NoSuchMethodException, SecurityException {

		Method mname = validateHomePage.class.getMethod("beforetest");
		DataUtil.DataConfiguration(mname);

	}
	


	@Test
	public void validateMakeMyTripPage() throws IOException {
		
		  
		  openbrowser();	
		  homePage hpage = new homePage().open(prop.getProperty("baseURl"));
		  hpage.gotoHotel();
		  if (!(new hotelspage().open().equals(null))){
			  Resusables.Reportinfo("Hotel page displayed");
		  }
		  hpage.gotoflight();
		  if (hpage.flight_tocity_btn.isDisplayed()) {
			  Resusables.Reportinfo("Home page -flight  displayed");
		  }
		  tearDown();
		
		  

	}

	
	@Test(dataProviderClass=DataUtil.class, dataProvider="datagenerator")
	public void FlightBooking(Hashtable<String,String> data) throws InterruptedException, IOException {
		
		openbrowser();
		
		homePage hpage = new homePage().open(prop.getProperty("baseURl"));
		hpage.checkRoundTrip();
		hpage.selectflightSource(data.get("From"));
		hpage.selectflightDest(data.get("To"));
		hpage.selectdate(data.get("Departure"));
		hpage.selectretdate(data.get("Return"));	
		Thread.sleep(6000);
		tearDown();

	}

}
