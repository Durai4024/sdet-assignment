package com.autify.qa.SeleniumJava;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutifyTest {

	WebDriver driver;

	@BeforeMethod(alwaysRun=true)
	public void setUp() {

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://autify.com/");
	}

	@Test(groups= {"Smoke"})
	public void newTabTest() {

		WebElement authifyLegacyLink = driver.findElement(By.xpath("//a[text()='Autify Legacy']"));
		authifyLegacyLink.click();

		Set<String> handler = driver.getWindowHandles();

		Iterator<String> it = handler.iterator();

		String parentWindowId = it.next();
		String childWindowId = it.next();

		driver.switchTo().window(childWindowId);

		String childWindowTitle = driver.getTitle();

		Assert.assertEquals(childWindowTitle,
				"Autify NoCode (formerly: Autify for Web, Autify for Mobile) | AI-based no-code test automation tool | Autify",
				"child window title is not matching");

		driver.close();

		driver.switchTo().window(parentWindowId);

		String patentWindowTitle = driver.getTitle();

		Assert.assertEquals(patentWindowTitle,
				"Autify｜AI and Quality Assurance Professionals Improve Development Productivity through Test Automation and Efficiency",
				"parent window title is not matching");
	}

	@Test(groups= {"Sanity"})
	public void signUpErrorMessageTest() {

		WebElement authifyLegacyLink = driver.findElement(By.xpath("//a[text()='Autify Legacy']"));
		authifyLegacyLink.click();

		Set<String> handler = driver.getWindowHandles();

		Iterator<String> it = handler.iterator();

		String parentWindowId = it.next();
		String childWindowId = it.next();

		driver.switchTo().window(childWindowId);

		WebElement freeTrialBtn = driver.findElement(By.xpath("//a[@class='white-button-aut w-button']"));

		freeTrialBtn.click();

		WebElement signUpBtn = driver.findElement(By.xpath("//button[@type='submit' and  text()='Sign up']"));

		signUpBtn.click();

		String firstNameErrorText = driver.findElement(By.xpath("//input[@name='first_name']/following-sibling::span"))
				.getText();

		String lastNameErrorText = driver.findElement(By.xpath("//input[@name='last_name']/following-sibling::span"))
				.getText();

		String companyErrorText = driver.findElement(By.xpath("//input[@name='company']/following-sibling::span"))
				.getText();

		String emailErrorText = driver.findElement(By.xpath("//input[@name='email']/following-sibling::span"))
				.getText();

		String pwdErrorText = driver.findElement(By.xpath("//input[@name='password']/following-sibling::span"))
				.getText();

		Assert.assertEquals(firstNameErrorText, "First name can't be blank",
				"First name error message is not displayed as expected");

		Assert.assertEquals(lastNameErrorText, "Last name can't be blank",
				"Last name error message is not displayed as expected");

		Assert.assertEquals(companyErrorText, "Company name can't be blank",
				"Company name error message is not displayed as expected");

		Assert.assertEquals(emailErrorText, "Email can't be blank",
				"Email ErrorTextrror message is not displayed as expected");

		Assert.assertEquals(pwdErrorText, "Password cannot be blank",
				"Password error message is not displayed as expected");

	}

	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}
}
