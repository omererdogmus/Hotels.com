package com.qa.hotels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.util.Constants;
import com.qa.hotels.util.ElementUtil;

public class HomePage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	WebElement element;

	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	// Locators
	By destination = By.id("qf-0q-destination");
	By checkIn = By.id("qf-0q-localised-check-in");
	By checkOut = By.id("qf-0q-localised-check-out");
	By rooms = By.id("qf-0q-rooms");
	By adults = By.id("qf-0q-room-0-adults");
	By children = By.id("qf-0q-room-0-children");
	By child1Age = By.id("qf-0q-room-0-child-0-age");
	By child2Age = By.id("qf-0q-room-0-child-1-age");
	By searchBtn = By.xpath("//button[contains(text(),'Search')]");

	// Methdos
	public String getPageTitle() {
		return elementUtil.doGetPageTitle();
	}

	public void whereTo() {
		selectingDesAndDates();
		selectingRoomsAdultsAndChildren();
		selectingChildrenAges();
		elementUtil.doClick(searchBtn);
	}

	public void selectingDesAndDates() {
		elementUtil.doSendKeys(destination, Constants.Destination);
		elementUtil.doSendKeys(checkIn, "11/26/2020");
		elementUtil.doSendKeys(checkOut, "11/29/2020");
	}

	public void selectingRoomsAdultsAndChildren() {
		element = driver.findElement(rooms);
		elementUtil.select(element, "1");
		element = driver.findElement(adults);
		elementUtil.select(element, "2");
		element = driver.findElement(children);
		elementUtil.select(element, "2");
	}

	public void selectingChildrenAges() {
		element = driver.findElement(child1Age);
		elementUtil.select(element, "4");
		element = driver.findElement(child2Age);
		elementUtil.select(element, "9");
	}

	public HiltonHotelsInCincinnati navigateCincinnatiHotels() {
		whereTo();
		return new HiltonHotelsInCincinnati(driver);
	}

	public TwoStarsHotelsPage twoStarHotels() {
		whereTo();
		return new TwoStarsHotelsPage(driver);
	}

	public ThreeStarsHotelsPage threeStarHotels() {
		whereTo();
		return new ThreeStarsHotelsPage(driver);
	}

	public FourStarsHotelsPage fourStarHotels() {
		whereTo();
		return new FourStarsHotelsPage(driver);
	}

}
