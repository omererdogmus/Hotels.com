package com.qa.hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.pages.FourStarsHotelsPage;
import com.qa.hotels.pages.HomePage;
import com.qa.hotels.util.Constants;

public class FourStarsHotelsPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	HomePage homePage;
	FourStarsHotelsPage fPage;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		properties = basePage.init_properties();
		String browserName = properties.getProperty("browser");
		driver = basePage.init_driver(browserName);
		homePage = new HomePage(driver);
		fPage = homePage.fourStarHotels();
	}
	
	@Test(priority = 1, description = "verify page title", enabled = false)
	public void verifyPageTitle() {
		String title = fPage.getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.Cincinnati_Page_Title);
	}
	
	@Test(priority = 2, description = "verify number of 4 stars hotels within 5 miles", enabled = true)
	public void selectFourStarAndAirport() throws InterruptedException {
		fPage.selectDistanceAndStar();
	}
	
	@Test(priority = 3, description = "verify number of 4 stars hotels", enabled = true)
	public void verifyFourStarHotels() throws InterruptedException {
		fPage.showFourStarsHotels();
	}
	
	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}

}
