package com.realpage.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleChromeBase {
	
	 private WebDriver driver;
		
	public GoogleChromeBase(WebDriver driver) {
			this.driver= driver;
			
		}	
	
	
	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;		
	}
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	public void type(String inputText, By locator) {
		WebDriverWait wait = new WebDriverWait (driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		driver.findElement(locator).sendKeys(inputText);
		
		
	}
	
	
	public void click(By locator) {
		WebDriverWait wait = new WebDriverWait (driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		driver.findElement(locator).click();
		
	}
	
	public void visit(String url) {
		driver.get(url);
	}
	
	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
		
		
	}
	
	public String getText(By locator) {
		WebDriverWait wait = new WebDriverWait (driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return driver.findElement(locator).getText();
		
	}
	
	public String getTitle() {	
		return driver.getTitle();
		
	}

}
