package com.orhrm.tests;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class SearchingTest {

    private WebDriver driver;
    private WebDriverWait wait;

    private static ExtentReports extent;
    private static ExtentSparkReporter spark;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @BeforeSuite
    public void initReport() {
        String root = System.getProperty("user.dir");
        new File(root + File.separator + "Reports").mkdirs();

        String ts = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportPath = root + File.separator + "Reports" + File.separator + "UI_Report_" + ts + ".html";

        spark = new ExtentSparkReporter(reportPath);
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("TutorialNinja Tests");

        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Tester", "Rishika Sharma");
        extent.setSystemInfo("Browser", "Chrome");
    }

    @AfterSuite(alwaysRun = true)
    public void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }

    @BeforeMethod
    public void setUp(Method method) {
        // WebDriverManager.chromedriver().setup(); // if using WebDriverManager
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        ExtentTest et = extent.createTest(method.getName(), "Search validation on TutorialNinja");
        test.set(et);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        try {
            String screenshot = takeScreenshot(result.getMethod().getMethodName());
            switch (result.getStatus()) {
                case ITestResult.FAILURE:
                    test.get().fail(result.getThrowable());
                    test.get().addScreenCaptureFromPath(screenshot);
                    break;
                case ITestResult.SUCCESS:
                    test.get().pass("Test passed");
                    test.get().addScreenCaptureFromPath(screenshot);
                    break;
                case ITestResult.SKIP:
                    test.get().skip("Test skipped: " + result.getThrowable());
                    test.get().addScreenCaptureFromPath(screenshot);
                    break;
            }
        } catch (Exception e) {
            test.get().warning("Screenshot attach failed: " + e.getMessage());
        } finally {
            if (driver != null) driver.quit();
        }
    }

    @Test(description = "Verify search flow for product 'macbook'")
    public void searching() {
        test.get().info("Open application");
        driver.get("https://tutorialsninja.com/demo/index.php?");
        driver.manage().window().setSize(new Dimension(1296, 688));

        test.get().info("Enter 'macbook' and search");
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("search")));
        searchBox.clear();
        searchBox.sendKeys("macbook");

        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-default")));
        searchBtn.click();

        test.get().info("Validate results contain 'MacBook'");
        boolean hasMac = driver.getPageSource().toLowerCase().contains("macbook");
        if (!hasMac) {
            throw new AssertionError("Search results did not contain 'MacBook'");
        }
        test.get().pass("Results validated");
        extent.flush();
    }

    private String takeScreenshot(String namePrefix) throws Exception {
        String root = System.getProperty("user.dir");
        String dir = root + File.separator + "Screenshots";
        new File(dir).mkdirs();

        String ts = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String path = dir + File.separator + namePrefix + "_" + ts + ".png";
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(path));
        return path;
    }
}

