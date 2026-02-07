package com.orhrm.base;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.orhrm.utilities.extentmanager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest extends extentmanager{
	@BeforeMethod
	  public void beforeMethod() {
		  System.out.println("This is Before Method");
			
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			ExtentReports extent = extentmanager.getreport();
			
	  }
	 
	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("This is After Method");
		  ChromiumDriver driver = null;
		  driver.quit();
	  }

}
