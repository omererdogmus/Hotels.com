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
import com.qa.hotels.util.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class HomePageTest {
	
	BasePage basePage;
	WebDriver driver;
	Properties properties;
	HomePage homePage;
	
	Logger log = Logger.getLogger(HomePageTest.class);
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		properties = basePage.init_properties();
		String browserName = properties.getProperty("browser");
		driver = basePage.init_driver(browserName);
		homePage = new HomePage(driver);
	}
	
	@Test(priority = 1, description = "verify page title", enabled = true)
	@Description("verify page title")
	@Severity(SeverityLevel.NORMAL)
	public void verifyPageTitle() {
		log.info("starting title method -------------------> verify home page");
		String title = homePage.getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.Home_Page_Title);
		log.info("ending title method -------------------> verify home page");
		log.warn("No warning");
		log.error("No error");
	}
	
	@Test(priority = 2, description = "destination handling", enabled = true)
	@Description("verify destination method")
	@Severity(SeverityLevel.CRITICAL)
	public void selectDestination() {
		log.info("starting destination method -------------------> verify home page");
		homePage.whereTo();
		log.info("ending destination method -------------------> verify home page");
		log.warn("No warning");
		log.error("No error");
	}
	
	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}

}
