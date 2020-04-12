/* This test case execute a successful search with the text "The name of the wind" and the 
  google search button is pressed and the user clicks on the first result */

package com.realpage.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleChromeTest {
	 private WebDriver driver;
	 GoogleChromePage chromePage;
	 String text ="The name of the wind";

	@BeforeClass
	public void beforeClass() throws Exception {
		 chromePage = new GoogleChromePage(driver);
		 driver = chromePage.chromeDriverConnection();
    	 chromePage.visit("https://www.google.com");
	}

	@AfterClass
	public void afterClass() throws Exception {
		driver.quit();
	}
	
//The test validates the presence of text "El nombre del viento" on the last page	
	@Test
	public void googleSearch() {
		chromePage.googleSearch(text);  
		Assert.assertTrue(chromePage.validateSearch(), "Successful Search");
	}

}
