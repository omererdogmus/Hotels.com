package com.qa.hotels.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.pages.HomePage;
import com.qa.hotels.pages.HiltonHotelsInCincinnati;
import com.qa.hotels.util.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class HiltonHotelsInCincinnatiTest {
	
	BasePage basePage;
	WebDriver driver;
	Properties properties;
	HomePage homePage;
	HiltonHotelsInCincinnati hCincinnati;
	
	Logger log = Logger.getLogger(HiltonHotelsInCincinnati.class);
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		properties = basePage.init_properties();
		String browserName = properties.getProperty("browser");
		browserName = properties.getProperty("browser");
		driver = basePage.init_driver(browserName);
		homePage = new HomePage(driver);
		hCincinnati = homePage.navigateCincinnatiHotels();
	}
	
	@Test(priority = 1, description = "verify page title", enabled = true)
	@Description("verify page title")
	@Severity(SeverityLevel.NORMAL)
	public void verifyPageTitle() {
		log.info("starting title method -------------------> verify hilton page");
		String title = hCincinnati.getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.Cincinnati_Page_Title);
		log.info("ending title method -------------------> verify hilton page");
		log.warn("No warning");
		log.error("No error");
	}
	
	@Test(priority = 2, description = "verify 3 star hilton hotels", enabled = true)
	@Description("verify hilton hotels method")
	@Severity(SeverityLevel.CRITICAL)
	public void hiltonHotelsWithThreeStars() throws InterruptedException {
		log.info("starting hilton hotels with 3 stars method -------------------> verify hilton page");
		hCincinnati.onlyHiltonWithThreeStar();
		log.info("ending hilton hotels with 3 stars method -------------------> verify hilton page");
		log.warn("No warning");
		log.error("No error");
	}
	
	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}
}
