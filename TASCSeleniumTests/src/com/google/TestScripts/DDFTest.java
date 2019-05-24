package com.google.TestScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.Pages.GoogleResultsPage;
import com.google.Pages.GoogleSearchPage;

import utils.ExcelCode;

public class DDFTest {
	WebDriver driver;
	String siteUrl = "http://www.google.com";

	@BeforeTest
	public void openBrowser() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(siteUrl);
	} 

	@Test(priority = 2)
	public void dataDrivenTest() throws IOException {

		GoogleSearchPage search = new GoogleSearchPage(driver);
		GoogleResultsPage results = new GoogleResultsPage(driver);

		String[][] Book1 = ExcelCode.getData("Book1.xlsx", "Sheet1");

		for (int i = 1; i < Book1.length; i++) {
			String testData = Book1[i][0];

			search.googleSearch(testData);
			// Assertion
			boolean didYouMeanVisble = results.getspellingCorrection().isDisplayed();
			Assert.assertTrue(didYouMeanVisble);

		}

	}

	@AfterTest
	public void closeBroswer() {
		driver.close();
	}
}
