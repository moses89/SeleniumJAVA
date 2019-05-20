package com.google.TestScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.Pages.GoogleSearchPage;

public class SearchResultsTest extends BaseTest {
	String data="Test";
	String attribute= "href";
	
	@Test(priority = 5)
	public void verifySearchResults(){
		
		
		GoogleSearchPage search = new GoogleSearchPage(driver);
		search.googleSearch(data);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a#pnnext")));
		List<WebElement> results = driver.findElements(By.cssSelector("h3.LC20lb"));
		for (WebElement element : results){
			
		System.out.println(element.getAttribute(attribute));
		System.out.println(element.getText());
		}
		// Clicked on Next button
		driver.findElement(By.cssSelector("a#pnnext")).click();; 
		
		//Clicked on previous button
		driver.findElement(By.cssSelector("a#pnprev")).click();
		
	}

}
