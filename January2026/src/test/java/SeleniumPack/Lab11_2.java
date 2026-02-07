package SeleniumPack;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class Lab11_2 {
	 WebDriver driver;
public Lab11_2(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	}
	  //	  JavascriptExecutor js;
	  @Test
	  public void f() {
		  driver.get("https://tutorialsninja.com/demo/index.php?");
		  Lab11_2 obj = new Lab11_2(driver);
		  driver.manage().window().setSize(new Dimension(550, 672));
		 obj.faBar();
		 obj.clickDesktop();
		 obj.clickMac();
		 obj.clickMac();
		 obj.clickSortSelect();
		 obj.clickMac();
		 obj.clickMac();
//		 js.executeScript("window.scrollTo(0,577.3333129882812)");
		 obj.clickSearch();
		 obj.clickInnerBox();
		 obj.forCursor();
		 obj.textEnter();
		 obj.descrip();
		 obj.ent();
	  }
	  private void ent() {
		// TODO Auto-generated method stub
		
	}
	  private void textEnter() {
		// TODO Auto-generated method stub
		
	}
	  private void descrip() {
		// TODO Auto-generated method stub
		
	}
	  private void forCursor() {
		// TODO Auto-generated method stub
		
	}
	  private void clickInnerBox() {
		// TODO Auto-generated method stub
		
	}
	  private void clickSearch() {
		// TODO Auto-generated method stub
		
	}
	  void clickSortSelect() {
		// TODO Auto-generated method stub
		
	}
	  void clickMac() {
		// TODO Auto-generated method stub
		
	}
	  void clickDesktop() {
		// TODO Auto-generated method stub
		
	}
	  void faBar() {
		// TODO Auto-generated method stub
		
	}
	  @BeforeMethod
	  public void beforeMethod() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  }
 
	  @AfterMethod
	  public void afterMethod() {
	  }
 
	  @BeforeClass
	  public void beforeClass() {
	  }
 
	  @AfterClass
	  public void afterClass() {
	  }
 
	  @BeforeTest
	  public void beforeTest() {
	  }
 
	  @AfterTest
	  public void afterTest() {
	  }
 
	  @BeforeSuite
	  public void beforeSuite() {
	  }
 
	  @AfterSuite
	  public void afterSuite() {
	  }
{
  }
}