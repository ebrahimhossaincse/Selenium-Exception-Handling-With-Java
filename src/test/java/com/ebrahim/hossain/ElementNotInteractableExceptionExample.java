package com.ebrahim.hossain;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementNotInteractableExceptionExample {
	WebDriver driver;
	String url = "https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php";

	@BeforeSuite
	public void startChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		driver = new ChromeDriver(options);
	}

	@BeforeClass
	public void openUrl() {
		driver.get(url);
	}

	@Test
	public void testElementNotVisibleException() {
		try {
			WebElement element = driver.findElement(By.id("hiddenElement"));
			element.click();
		} catch (ElementNotInteractableException e) {
			System.out.println("Element not visible: " + e.getMessage());
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
