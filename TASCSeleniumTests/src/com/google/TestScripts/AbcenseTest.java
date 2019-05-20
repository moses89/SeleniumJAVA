package com.google.TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.Pages.GoogleResultsPage;
import com.google.Pages.GoogleSearchPage;

public class AbcenseTest extends BaseTest {
	String data = "abcense";

	@Test(priority = 2)
	public void verifyAbcenseTest() {

		GoogleSearchPage search = new GoogleSearchPage(driver);
		search.googleSearch(data);
		GoogleResultsPage results = new GoogleResultsPage(driver);
		  //Assertion
		boolean didYouMeanVisble = results.getspellingCorrection().isDisplayed();
		Assert.assertTrue(didYouMeanVisble);

	}

}
