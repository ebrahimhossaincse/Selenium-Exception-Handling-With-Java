package com.ebrahim.hossain;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TimeoutExceptionExample {
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
	public void testTimeoutException() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		try {
			@SuppressWarnings("unused")
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("slowElement")));
		} catch (TimeoutException e) {
			System.out.println("Element not found within the time frame: " + e.getMessage());
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
