package com.ebrahim.hossain;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			// Wait until the element is visible and clickable
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("hiddenElement")));
			element.click();
		} catch (ElementNotInteractableException e) {
			System.out.println("Element not interactable: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("An unexpected exception occurred: " + e.getMessage());
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
