package com.google.TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.Pages.GoogleResultsPage;
import com.google.Pages.GoogleSearchPage;

public class AcceptibleTest extends BaseTest {
	String data = "acceptible";

	@Test(priority = 0)
	public void verifyGoogleSearch() {

		GoogleSearchPage search = new GoogleSearchPage(driver);
		search.googleSearch(data);
		GoogleResultsPage results = new GoogleResultsPage(driver);
		  //Assertion
		boolean didYouMeanVisble = results.getspellingCorrection().isDisplayed();
		Assert.assertTrue(didYouMeanVisble);

	}

}
