//package SeleniumPack;
//import java.io.File;
//
////import org.dom4j.Document;
//
//import org.dom4j.Element;
//
//import org.dom4j.io.SAXReader;
//
//import org.openqa.selenium.By;
//
//import org.openqa.selenium.WebDriver;
//
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class lab13 {
//
//    public static void main(String[] args) throws Exception {
//
//        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//
//        WebDriver driver = new ChromeDriver();
//
//        driver.manage().window().maximize();
//
//        driver.get("https://example.com/login");
//
//        SAXReader reader = new SAXReader();
//
//        Document document = reader.read(
//
//            new File("src/ObjectRepository.xml")
//
//        );
//
//        Element root = document.getRootElement();
//
//        String uname = root.element("username").getText();
//
//        String pass = root.element("password").getText();
//
//        String login = root.element("login_button").getText();
//
//        driver.findElement(By.xpath(uname)).sendKeys("admin");
//
//        driver.findElement(By.xpath(pass)).sendKeys("admin123");
//
//        driver.findElement(By.xpath(login)).click();
//
//    }
//
//}
 