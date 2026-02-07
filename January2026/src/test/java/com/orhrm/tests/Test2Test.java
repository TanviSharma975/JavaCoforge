//package com.orhrm.tests;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.core.IsNot.not;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.Keys;
//import java.util.*;
//import java.net.MalformedURLException;
//import java.net.URL;
//public class Test2Test {
//  private WebDriver driver;
//  private Map<String, Object> vars;
//  JavascriptExecutor js;
//  @BeforeMethod
//  public void setUp() {
//    driver = new FirefoxDriver();
//    js = (JavascriptExecutor) driver;
//    vars = new HashMap<String, Object>();
//  }
//  @AfterMethod
//  public void tearDown() {
//    driver.quit();
//  }
//  @Test
//  public void test2() {
//    driver.get("https://tutorialsninja.com/");
//    driver.manage().window().setSize(new Dimension(1070, 672));
//    driver.findElement(By.linkText("https://tutorialsninja.com/demo")).click();
//    driver.findElement(By.linkText("Desktops")).click();
//    driver.findElement(By.linkText("Mac (1)")).click();
//    driver.findElement(By.cssSelector(".button-group .fa-shopping-cart")).click();
//    js.executeScript("window.scrollTo(0,368.6666564941406)");
//    driver.findElement(By.cssSelector(".btn-inverse")).click();
//    {
//      WebElement element = driver.findElement(By.id("grid-view"));
//      Actions builder = new Actions(driver);
//      builder.moveToElement(element).perform();
//    }
//    {
//      WebElement element = driver.findElement(By.tagName("body"));
//      Actions builder = new Actions(driver);
//      builder.moveToElement(element, 0, 0).perform();
//    }
//  }
//}
//
//
//
//}

package com.orhrm.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test2Test {

  private WebDriver driver;
  private Map<String, Object> vars;
  private JavascriptExecutor js;

  // ===== ExtentReports fields =====
  private static ExtentReports extent;
  private static ThreadLocal<ExtentTest> testTL = new ThreadLocal<>();

  // ===== Suite-level setup/teardown =====
  @BeforeSuite(alwaysRun = true)
  public void initReport() {
    String projectPath = System.getProperty("user.dir");
    String reportPath = projectPath + File.separator + "jan28th_Report.html";

    ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
    spark.config().setTheme(Theme.STANDARD);
    spark.config().setDocumentTitle("Automation Test Report");
    spark.config().setReportName("TutorialsNinja - Selenium TestNG Report");

    extent = new ExtentReports();
    extent.attachReporter(spark);

    extent.setSystemInfo("Tester", "Tanvi Sharma");
    extent.setSystemInfo("Browser", "Firefox");
    extent.setSystemInfo("Suite Start Time", new Date().toString());

    // Ensure Screenshots folder exists
    try {
      Files.createDirectories(Paths.get("." + File.separator + "Screenshots"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @AfterSuite(alwaysRun = true)
  public void flushReport() {
    if (extent != null) {
      extent.flush();
    }
  }

  // ===== Test-level setup/teardown =====
  @BeforeMethod(alwaysRun = true)
  public void setUp(Method method) {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<>();

    // Stable size helps rendering and avoids white screenshots in some envs
    driver.manage().window().setSize(new Dimension(1366, 900));

    // Create a test node for the current method
    ExtentTest t = extent.createTest(method.getName())
        .assignCategory(this.getClass().getSimpleName());
    testTL.set(t);

    t.info("Launching Firefox and starting test: " + method.getName());
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown(ITestResult result) {
    try {
      ExtentTest t = testTL.get();

      if (result.getStatus() == ITestResult.SUCCESS) {
        t.pass("Test passed");
      } else if (result.getStatus() == ITestResult.FAILURE) {
        // Ensure we are looking at the right content before capture
        safeSwitchToLatestWindow();
        safeWaitForPageReady(8000);

        // Capture screenshot with timestamp and attach to report
        try {
          File src = takeReliableScreenshot();
          String dest = buildScreenshotPath(result.getName());
          FileUtils.copyFile(src, new File(dest));
          t.fail("Failure screenshot attached").addScreenCaptureFromPath(dest);
        } catch (Exception shotEx) {
          t.fail("Failed to capture screenshot: " + shotEx.getMessage());
        }

        // Also log the stacktrace
        if (result.getThrowable() != null) {
          t.fail(result.getThrowable());
        }
      } else if (result.getStatus() == ITestResult.SKIP) {
        String reason = (result.getThrowable() != null ? result.getThrowable().getMessage() : "No reason");
        t.skip("Test skipped: " + reason);
      }
    } finally {
      if (driver != null) {
        driver.quit();
      }
    }
  }

  // ===== Your test (steps kept; navigation to demo made reliable) =====
  @Test
  public void test2() {
    ExtentTest t = testTL.get();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));

    // 1) Go to TutorialsNinja homepage
    t.info("Navigating to TutorialsNinja homepage");
    driver.get("https://tutorialsninja.com/");
    waitForPageReady(8000);

    // 2) Navigate to the demo site reliably.
    // Your original By.linkText("https://tutorialsninja.com/demo") is unlikely to match link text.
    // You can either click a proper link or navigate directly:
    t.info("Navigating directly to demo site");
    driver.get("https://tutorialsninja.com/demo/");
    waitForPageReady(8000);

    // Optional: wait for a stable element on the demo page (e.g., logo/menu)
    try {
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logo")));
    } catch (TimeoutException e) {
      t.warning("Logo not visible yet; continuing with next steps.");
    }

    // 3) Desktops -> Mac (1)
    t.info("Clicking 'Desktops'");
    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Desktops"))).click();

    t.info("Clicking 'Mac (1)'");
    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Mac (1)"))).click();

    // 4) Add first Mac product to cart
    t.info("Adding first Mac product to cart");
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".button-group .fa-shopping-cart"))).click();

    // 5) Scroll and open mini-cart
    t.info("Scrolling and opening mini-cart");
    js.executeScript("window.scrollTo(0, 400)");
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-inverse"))).click();

    // 6) Hover actions (as in your original code)
    t.info("Hover actions on grid-view and body");
    WebElement gridView = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grid-view")));
    new Actions(driver).moveToElement(gridView).perform();

    WebElement body = driver.findElement(By.tagName("body"));
    new Actions(driver).moveToElement(body, 0, 0).perform();

    t.pass("Test steps executed successfully");
    extent.flush();
  }

  // ===== Utilities =====

  private void waitForPageReady(long timeoutMs) {
    new WebDriverWait(driver, Duration.ofMillis(timeoutMs))
        .until(d -> ((JavascriptExecutor) d)
            .executeScript("return document.readyState").toString().equals("complete"));
  }

  // Best-effort; ignore if only one window
  private void safeSwitchToLatestWindow() {
    try {
      String current = driver.getWindowHandle();
      for (String handle : driver.getWindowHandles()) {
        if (!handle.equals(current)) {
          driver.switchTo().window(handle);
        }
      }
    } catch (Exception ignored) { }
  }

  private void safeWaitForPageReady(long timeoutMs) {
    try {
      waitForPageReady(timeoutMs);
    } catch (Exception ignored) { }
  }

  // Prefer Firefox full-page screenshot; fallback to viewport
  private File takeReliableScreenshot() throws IOException {
    if (driver instanceof FirefoxDriver) {
      try {
        return ((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);
      } catch (Throwable ignored) {
        // Fallback
      }
    }
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
  }

  private String buildScreenshotPath(String testName) throws IOException {
    String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    String dir = "." + File.separator + "Screenshots";
    Files.createDirectories(Paths.get(dir));
    return dir + File.separator + testName + "_" + timestamp + ".png";
  }
}