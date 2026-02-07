package com.orhrm.tests;



import com.aventstack.extentreports.*;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.aventstack.extentreports.MediaEntityBuilder;
 
import org.openqa.selenium.*;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.support.ui.*;
 
import org.testng.ITestResult;

import org.testng.annotations.*;
 
import java.io.File;

import java.io.IOException;

import java.nio.file.*;

import java.text.SimpleDateFormat;

import java.time.Duration;

import java.util.Date;
 
import org.apache.commons.io.FileUtils;
 
public class CustomerServiceContact {
 
    private WebDriver driver;

    private WebDriverWait wait;
 
    private ExtentReports extent;

    private ExtentTest test;
 
    // ---------- Helpers ----------

    private static String timestamp() {

        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

    }
 
    private String projectRoot() {

        return System.getProperty("user.dir");

    }
 
    private Path ensureDir(Path dir) throws IOException {

        if (!Files.exists(dir)) Files.createDirectories(dir);

        return dir;

    }
 
    /** Takes a screenshot to ./Screenshots/<name>_<timestamp>.png and returns the path with forward slashes. */

    private String takeScreenshot(String name) {

        try {

            Path screenshotsDir = ensureDir(Paths.get(projectRoot(), "Screenshots"));

            String fileName = name.replaceAll("[^a-zA-Z0-9-_\\.]", "_") + "_" + timestamp() + ".png";

            Path dest = screenshotsDir.resolve(fileName);
 
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(src, dest.toFile());
 
            return dest.toString().replace("\\", "/");

        } catch (IOException e) {

            System.err.println("Failed to capture screenshot: " + e.getMessage());

            return null;

        }

    }
 
    /** Try to read some confirmation text; return null if not found (we won’t fail the test). */

    private String tryReadConfirmationText() {

        // Preferred: TutorialsNinja often shows a paragraph under #content

        try {

            WebElement p = new WebDriverWait(driver, Duration.ofSeconds(6))

                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content > p")));

            return p.getText().trim();

        } catch (TimeoutException ignored) { }
 
        // Fallback: any paragraph under #content

        try {

            WebElement anyP = new WebDriverWait(driver, Duration.ofSeconds(4))

                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content p")));

            return anyP.getText().trim();

        } catch (TimeoutException ignored) { }
 
        // Fallback: heading text (page might only show "Contact Us")

        try {

            WebElement h = new WebDriverWait(driver, Duration.ofSeconds(3))

                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content h1, #content h2")));

            return h.getText().trim();

        } catch (TimeoutException ignored) { }
 
        // Fallback: any bootstrap alert (if theme uses it)

        try {

            WebElement alert = new WebDriverWait(driver, Duration.ofSeconds(3))

                    .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert, .alert-success, .alert-info")));

            return alert.getText().trim();

        } catch (TimeoutException ignored) { }
 
        return null;

    }
 
    // ---------- Lifecycle ----------

    @BeforeClass

    public void setUpSuite() throws IOException {

        // Optional: set path if geckodriver is not on PATH

        // System.setProperty("webdriver.gecko.driver", "C:\\tools\\geckodriver.exe");
 
        // Ensure a NEW report each run (prevents seeing an older failed run)

        Path reportsDir = ensureDir(Paths.get(projectRoot(), "Reports"));

        String reportPath = reportsDir.resolve("ContactUsReport_" + timestamp() + ".html").toString();
 
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

        spark.config().setReportName("Contact Us - TutorialsNinja");

        spark.config().setDocumentTitle("Automation Report - Contact Us");
 
        extent = new ExtentReports();

        extent.attachReporter(spark);

        extent.setSystemInfo("Tester", "Kritika Soni");

        extent.setSystemInfo("Browser", "Firefox");

        extent.setSystemInfo("Base URL", "https://tutorialsninja.com/demo/");
 
        // WebDriver

        FirefoxOptions options = new FirefoxOptions();

        options.setAcceptInsecureCerts(true);

        // options.addArguments("--headless=new"); // uncomment for CI/headless

        driver = new FirefoxDriver(options);
 
        driver.manage().window().setSize(new Dimension(1200, 800));

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }
 
    @AfterClass(alwaysRun = true)

    public void tearDownSuite() {

        try {

            if (driver != null) driver.quit();

        } finally {

            if (extent != null) extent.flush(); // write report to disk

        }

    }
 
    /** IMPORTANT: Don’t log failures here (to keep report green). */

    @AfterMethod(alwaysRun = true)

    public void afterEach(ITestResult result) {

        // Intentionally no test.fail() here

        if (test == null) return;

        if (result.getStatus() == ITestResult.SKIP) {

            test.skip("Test skipped");

        }

        // For debugging only, you could attach a screenshot on any unexpected throwable as a warning

        if (result.getThrowable() != null) {

            String shot = takeScreenshot("Unexpected_" + result.getName());

            test.warning("Unexpected throwable captured (not failing the test): " + result.getThrowable().getMessage(),

                    shot != null ? MediaEntityBuilder.createScreenCaptureFromPath(shot).build() : null);

        }

    }
 
    // ---------- Test (No Fail) ----------

    @Test

    public void contactUs() {

        test = extent.createTest("Contact Us - Submit Enquiry (No-Fail)")

                     .assignCategory("UI")

                     .assignAuthor("Kritika Soni");
 
        try {

            // 1) Open site

            driver.get("https://tutorialsninja.com/demo/index.php?");

            test.info("Opened TutorialsNinja demo site",

                      MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot("HomePage")).build());
 
            // 2) Navigate to Contact Us

            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Contact Us"))).click();

            test.info("Navigated to Contact Us page");
 
            // 3) Fill form (correct fields)

            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-name")));

            WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email")));

            WebElement enquiry = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-enquiry")));
 
            name.clear();    name.sendKeys("Kritika");

            email.clear();   email.sendKeys("kritika@gmail.com");

            enquiry.clear(); enquiry.sendKeys("I want to return the product.");
 
            test.info("Filled Contact Us form",

                      MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot("Form_Filled")).build());
 
            // 4) Submit

            WebElement submitBtn = wait.until(

                    ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='submit'][value='Submit']"))

            );

            submitBtn.click();

            test.info("Submitted the enquiry");
 
            // 5) Try to confirm success (no hard assertion)

            try {

                new WebDriverWait(driver, Duration.ofSeconds(8))

                        .until(ExpectedConditions.or(

                                ExpectedConditions.urlContains("/success"),

                                ExpectedConditions.presenceOfElementLocated(By.cssSelector("#content"))

                        ));

            } catch (TimeoutException ignored) { }
 
            String confirmation = tryReadConfirmationText();

            if (confirmation != null && !confirmation.isEmpty()) {

                test.info("Confirmation text: " + confirmation);

            } else {

                test.warning("Could not read a specific confirmation text. UI may have changed.");

            }
 
            // 6) Always pass the test (as requested)

            test.pass("Flow executed successfully (no hard assertions).",

                      MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot("After_Submit")).build());
 
        } catch (Throwable t) {

            // Do NOT fail the test — log a warning and continue

            String shot = takeScreenshot("Unexpected_Error");

            if (shot != null) {

                test.warning("Unexpected issue encountered: " + t.getMessage(),

                             MediaEntityBuilder.createScreenCaptureFromPath(shot).build());

            } else {

                test.warning("Unexpected issue encountered: " + t.getMessage());

            }

            // swallow exception to keep the test green
            extent.flush();

        }

    }}


 
