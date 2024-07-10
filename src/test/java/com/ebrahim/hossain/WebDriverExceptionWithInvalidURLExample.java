package com.ebrahim.hossain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverExceptionWithInvalidURLExample {
	WebDriver driver;
	String url = "https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php";

	@BeforeSuite
	public void startChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		driver = new ChromeDriver(options);
	}

	@Test
	public void testWebDriverExceptionWithInvalidURL() {
		try {
			driver.get("invalid-url");
		} catch (WebDriverException e) {
			System.out.println("WebDriver exception with invalid URL: " + e.getMessage());
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
