package com.qa.hotels.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hotels.util.ElementUtil;
import com.qa.hotels.util.JavaScriptUtil;

public class TwoStarsHotelsPage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil jsUtil;
	
	// Constructor
	public TwoStarsHotelsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}
	
	// Locators
	By twoStar = By.id("f-star-rating-2");
	By landmarks = By.xpath("//h3[contains(text(),'Landmarks')]");
	By airport = By.id("f-label-lid-1664964");
	By distance = By.id("f-distance");
	By milesToAirport = By.className("property-landmarks");
	By hotelsThreeStars = By.className("star-rating-text");
	By allHotelLinks = By.className("property-name-link");
	
	// Methods
	public String getPageTitle() {
		return elementUtil.doGetPageTitle();
	}
	
	public void selectDistanceAndStar() throws InterruptedException {
		elementUtil.doClick(twoStar);
		elementUtil.doClick(landmarks);
		elementUtil.doClick(airport);
		elementUtil.waitForElementPresent(distance);
		WebElement element = driver.findElement(distance);
		elementUtil.select(element, "5 miles");
		Thread.sleep(3000);
		List<WebElement> milesList = driver.findElements(milesToAirport);
		System.out.println("Numbers of hotels that are within 5 miles radius to the airport : " + milesList.size() + "\n");
		for(int i = 0; i < milesList.size(); i++) {
			String list = milesList.get(i).getText();
			System.out.println(list);
		}
		List<WebElement> hotelsWithin5Miles = driver.findElements(allHotelLinks);
		System.out.println();
		System.out.println("Name of the hotels that are within five miles to the airport : \n");
		for(int i = 0; i < hotelsWithin5Miles.size(); i++) {
			String list = hotelsWithin5Miles.get(i).getText();
			System.out.println(list);
		}
	}
	
	public void showTwoStarsHotels() throws InterruptedException {
		elementUtil.doClick(twoStar);
		elementUtil.doClick(landmarks);
		elementUtil.doClick(airport);
		elementUtil.waitForElementPresent(distance);
		WebElement element = driver.findElement(distance);
		elementUtil.select(element, "5 miles");
		Thread.sleep(3000);
		List<WebElement> starList = driver.findElements(hotelsThreeStars);
		System.out.println("Numbers of hotels that have 2 stars : " + starList.size());
		for(int i = 0; i < starList.size(); i++) {
			String list2Stars = starList.get(i).getText();
			System.out.println(list2Stars);
		}
	}


}
