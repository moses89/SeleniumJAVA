package com.google.TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.Pages.GoogleResultsPage;
import com.google.Pages.GoogleSearchPage;

public class UnderateTest extends BaseTest {
	String data="underate"; 

	@Test(priority = 3)
	public void verifyUnderateTest() {

		GoogleSearchPage search = new GoogleSearchPage(driver);
		search.googleSearch(data);
		GoogleResultsPage results = new GoogleResultsPage(driver);
		  //Assertion
		boolean didYouMeanVisble = results.getspellingCorrection().isDisplayed();
		Assert.assertTrue(didYouMeanVisble);

	}
}