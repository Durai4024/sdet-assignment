package com.autify.qa.SeleniumJava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AutifyTest {
	
  @Test
  public void newTabTest() throws InterruptedException {
	   
	  WebDriver driver = new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	 
	  driver.get("https://autify.com/");
	  
	  Thread.sleep(10);
	  
	  driver.quit();
  }
}
