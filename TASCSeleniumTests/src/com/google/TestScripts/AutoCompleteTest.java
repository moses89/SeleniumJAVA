package com.google.TestScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AutoCompleteTest extends BaseTest {
	String data = "java";
	String itemToClick="java jdk";

	@Test(priority = 4)
	public void verifyAutoCompleteDropDown() throws InterruptedException {

		driver.findElement(By.name("q")).sendKeys(data);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@role='listbox']/li/descendant::div[@class='sbl1']")));
		
		List<WebElement> list = driver
				.findElements(By.xpath("//ul[@role='listbox']/li/descendant::div[@class='sbl1']"));
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			String listitem = list.get(i).getText();
			System.out.println(listitem);
			if (listitem.contains(itemToClick)) { 
				list.get(i).click();
				break;
			}

		}
	}
}