/* This test case execute a search of a incorrect text and compare it with this correct text  
  "The name of the wind" */

package com.realpage.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleChromeWrongSearchTest {
	 private WebDriver driver;
	 GoogleChromePage chromePage;
	 String text ="The name of the wind";
	 String wrongText ="Text is not correct  ";

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

	@Test
	public void wrongGoogleSearch() {
		chromePage.wrongGoogleSearch(wrongText);  
		Assert.assertNotEquals(chromePage.getTextOfElement(),text);
	}

}
