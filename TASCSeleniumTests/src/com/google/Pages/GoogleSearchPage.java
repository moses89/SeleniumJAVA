package com.google.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GoogleSearchPage {

	@FindBy(name = "q")
	private WebElement searchBox;

	@FindBy(name = "btnK")
	private WebElement googleSearchButton;

	// Constructor
	public GoogleSearchPage(WebDriver driver) {

		// Initialize Elements
		PageFactory.initElements(driver, this);

	}

	public void googleSearch(String testData) {

		searchBox.sendKeys(testData);
		googleSearchButton.click();
		
	}
	 
	
	}

