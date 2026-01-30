package SeleniumPack;
import java.time.Duration;
 
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class Lab11_2_TestNG {
 
  WebDriver driver;
 
  @Test
  public void f() {
    driver.get("https://tutorialsninja.com/demo/index.php?");
    Lab11_PageFactory_2 obj = PageFactory.initElements(driver, Lab11_PageFactory_2.class);
    driver.manage().window().setSize(new Dimension(550, 672));
    obj.faBar();
    obj.clickDesktop();
    obj.clickMac();
    obj.clickSort();
    obj.clickSortSelect();
    obj.clickChild();
    obj.clickCart();
    obj.clickSearch();
    obj.clickInnerBox();
    obj.forCursor();
    obj.textEnter();
    obj.descrip();
    obj.ent();
  }
 
  @BeforeMethod
  public void beforeMethod() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.manage().window().maximize();
  }
 
  @AfterMethod
  public void afterMethod() {
    if (driver != null) driver.quit();
  }
 
  @BeforeClass public void beforeClass() {}
  @AfterClass public void afterClass() {}
  @BeforeTest public void beforeTest() {}
  @AfterTest public void afterTest() {}
  @BeforeSuite public void beforeSuite() {}
  @AfterSuite public void afterSuite() {}
}
