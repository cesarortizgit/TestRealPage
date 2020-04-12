/* This test case execute a search and compare the text of the first result with this text 
  "The Name of the Wind - Patrick Rothfuss" */

package com.realpage.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class GoogleChromeSuggestTestCompareResult {
	 private WebDriver driver;
	 GoogleChromePage chromePage;
	 String expectedText ="The Name of the Wind - Patrick Rothfuss";
	 String searchtext ="The name of the w";

  
  @BeforeClass
  public void beforeClass() {
	  chromePage = new GoogleChromePage(driver);
	  driver = chromePage.chromeDriverConnection();
	  chromePage.visit("https://www.google.com");
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  /*This test compare the text of first result with the text expected*/
  @Test
  public void suggestTestCompareResult() {
		chromePage.suggestTestCompareResult(searchtext); 
		Assert.assertNotEquals(chromePage.getTextOfFirstResult(),expectedText);

	  
  }

}
