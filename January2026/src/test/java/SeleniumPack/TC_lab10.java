package SeleniumPack;

import java.io.File;
import java.net.URL;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.apache.commons.io.FileUtils;
public class TC_lab10 {
   static WebDriver driver;
   public static void main(String[] args) throws Exception {
       DesiredCapabilities cap = new DesiredCapabilities();
       cap.setPlatform(Platform.WINDOWS);
       cap.setBrowserName("firefox");   // chrome / firefox / internet explorer
       cap.setVersion("");
       driver = new RemoteWebDriver(
               new URL("http://localhost:4444/wd/hub"),
               cap
       );
       // Step 1
       driver.get("https://demo.guru99.com/test/login.html");
       takeScreenshot("step1_open_site");
       // Step 2
       driver.findElement(By.id("email")).sendKeys("test@gmail.com");
       takeScreenshot("step2_enter_email");
       // Step 3
       driver.findElement(By.id("passwd")).sendKeys("password123");
       takeScreenshot("step3_enter_password");
       // Step 4
       driver.findElement(By.id("SubmitLogin")).click();
       takeScreenshot("step4_login_click");
       driver.quit();
   }
   public static void takeScreenshot(String fileName) throws Exception {
       File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(src,
               new File("Screenshots/" + fileName + ".png"));
   }
}