

package com.orhrm.tests;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class Test2Test {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @BeforeMethod
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void test2() {
    driver.get("https://tutorialsninja.com/");
    driver.manage().window().setSize(new Dimension(1070, 672));
    driver.findElement(By.linkText("https://tutorialsninja.com/demo")).click();
    driver.findElement(By.linkText("Desktops")).click();
    driver.findElement(By.linkText("Mac (1)")).click();
    driver.findElement(By.cssSelector(".button-group .fa-shopping-cart")).click();
    js.executeScript("window.scrollTo(0,368.6666564941406)");
    driver.findElement(By.cssSelector(".btn-inverse")).click();
    {
      WebElement element = driver.findElement(By.id("grid-view"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
  }
}
