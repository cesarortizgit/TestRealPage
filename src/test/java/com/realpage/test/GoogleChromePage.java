package com.realpage.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleChromePage extends GoogleChromeBase {
		
	By searchBox = By.name("q");
	By spaceBlank = By.xpath("//body[@id='gsr']/div[@id='viewport']/div[@id='searchform']/form[@id='tsf']/div[2]");
	By btnSearch = By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']");

	By suggestion= By.xpath("//li[1]//div[1]//div[2]//div[1]//span[1]"); 
    By firstResult = By.xpath("//h3[contains(text(),'El nombre del viento - Wikipedia, la enciclopedia')]");
    By textOnthePage = By.xpath("//h1[@id='firstHeading']");
	public GoogleChromePage(WebDriver driver) {
		super(driver);
		
	}

	public void googleSearch(String text) {
		type(text,searchBox);
		click(spaceBlank);
		click(btnSearch);
		click(firstResult);

	}
	
	public void wrongGoogleSearch(String text) {
		type(text,searchBox);
		click(btnSearch);

		
	}
	
	public void blanKGoogleSearch(String text) {
		type(text,searchBox);
		click(btnSearch);

		
	}

	
	public void googleSearchSuggest(String text) {
		type(text,searchBox);
		click(suggestion);
		click(firstResult);		
	}
	
	public void suggestTestCompareResult(String text) {
		type(text,searchBox);
		click(suggestion);		
	}
	
	public void compareResultPage(String text) {
		type(text,searchBox);
		click(suggestion);	
		click(firstResult);		
	}
	
	public Boolean validateSearch() {
		return isDisplayed(textOnthePage);
	}
	
	public String getTextOfElement() {
		return getText(searchBox);
	}
	
	public String getTextOfFirstResult() {
		return getText(firstResult);
	}
	
	public String getTitleOfPage() {
		return getTitle();
	}
	
		

}
