package com.qa.hotels.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hotels.util.ElementUtil;
import com.qa.hotels.util.JavaScriptUtil;

public class HiltonHotelsInCincinnati {

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil jsUtil;

	// Constructor
	public HiltonHotelsInCincinnati(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}

	// Locators
	By threeStar = By.id("f-star-rating-3");
	By distance = By.xpath("//h3[contains(text(),'Landmarks')]");
	By allHotelLinks = By.className("property-name-link");
	By nameContains = By.id("f-name");
	By nameContainsBtn = By.id("f-name-cta");

	// Methods
	public String getPageTitle() {
		return elementUtil.doGetPageTitle();
	}

	public void onlyHiltonWithThreeStar() throws InterruptedException {
		elementUtil.doClick(threeStar);
		Thread.sleep(4000);
		List<WebElement> linklist = driver.findElements(allHotelLinks);
		System.out.println("total hotels that have 3 stars : " + linklist.size());
		for (int i = 0; i < linklist.size(); i++) {
			String hotels = linklist.get(i).getText();
			if(hotels.contains("hilton")) {
				System.out.println("hilton hotels are : " + hotels);
			}
		}
	}
}
