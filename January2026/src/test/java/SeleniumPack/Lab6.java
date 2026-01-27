package SeleniumPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
 
public class Lab6 {
 
    public static void main(String[] args) {
 
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
        driver.manage().window().maximize();
        driver.get("http://demo.opencart.com/");
 
        /*  LOGIN  */
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
 
        driver.findElement(By.id("input-email"))
                .sendKeys("your_email@example.com");
        driver.findElement(By.id("input-password"))
                .sendKeys("your_password");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
 
        /* - COMPONENTS → MONITORS -*/
        driver.findElement(By.linkText("Components")).click();
        driver.findElement(By.linkText("Monitors (2)")).click();
 
        /* ---------- SHOW 25 ---------- */
        Select showDropdown = new Select(driver.findElement(By.id("input-limit")));
        showDropdown.selectByVisibleText("25");
 
        /* ---------- ADD FIRST ITEM TO CART ---------- */
        driver.findElement(By.xpath("(//button[@data-original-title='Add to Cart'])[1]")).click();
 
        /* ---------- SPECIFICATION TAB ---------- */
        driver.findElement(By.linkText("Specification")).click();
 
        /* ---------- VERIFY DETAILS PRESENT ---------- */
        WebElement specTable = driver.findElement(By.xpath("//table[@class='table table-bordered']"));
        if (specTable.isDisplayed()) {
            System.out.println("Specifications are present");
        }
 
        /* ---------- ADD TO WISH LIST ---------- */
        driver.findElement(By.xpath("//button[@data-original-title='Add to Wish List']")).click();
 
        String wishMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success"))
        ).getText();
 
        System.out.println(wishMsg);
 
        /* ---------- SEARCH MOBILE ---------- */
        driver.findElement(By.name("search")).sendKeys("Mobile");
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        driver.findElement(By.name("description")).click();
 
        driver.findElement(By.linkText("HTC Touch HD")).click();
 
        /* ---------- UPDATE QTY ---------- */
        WebElement qty = driver.findElement(By.id("input-quantity"));
        qty.clear();
        qty.sendKeys("3");
 
        driver.findElement(By.id("button-cart")).click();
 
        String cartMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success"))
        ).getText();
 
        System.out.println(cartMsg);
 
        /* ---------- VIEW CART ---------- */
        driver.findElement(By.id("cart-total")).click();
        driver.findElement(By.linkText("View Cart")).click();
 
        /* ---------- VERIFY MOBILE IN CART ---------- */
        WebElement cartProduct = driver.findElement(By.linkText("HTC Touch HD"));
        if (cartProduct.isDisplayed()) {
            System.out.println("Mobile added to cart successfully");
        }
 
        /* ---------- CHECKOUT ---------- */
        driver.findElement(By.linkText("Checkout")).click();
 
        /* ---------- LOGOUT ---------- */
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Logout")).click();
 
        WebElement logoutHeading = driver.findElement(By.xpath("//h1[text()='Account Logout']"));
        if (logoutHeading.isDisplayed()) {
            System.out.println("Logout successful");
        }
 
        driver.findElement(By.linkText("Continue")).click();
 
        driver.quit();
    }
}
 