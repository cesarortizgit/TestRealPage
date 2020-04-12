/* This test case execute a search and compare the title of the page with the title 
  "The Name of the Wind - Patrick Rothfuss" */
package com.realpage.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class GoogleChromeSuggestTestComparePage {
	 private WebDriver driver;
	 GoogleChromePage chromePage;
	 String expectedTitle ="Patrick Rothfuss - The Books" ;
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
  
  @Test
  public void compareTitleofPage() {
		chromePage.compareResultPage(searchtext); 
		System.out.println(chromePage.getTitleOfPage());
		Assert.assertNotEquals(chromePage.getTitleOfPage(),expectedTitle);

  }

}
