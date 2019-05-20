package com.google.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleResultsPage {

	@FindBy(css = "#taw > div:nth-child(2) > div > p > span")
	private WebElement spellingCorrection;

	public GoogleResultsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	public WebElement getspellingCorrection() {

		return spellingCorrection;
	}
}
