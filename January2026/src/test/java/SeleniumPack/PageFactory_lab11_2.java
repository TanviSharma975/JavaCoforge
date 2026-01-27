package SeleniumPack;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
 
public class PageFactory_lab11_2 {
 
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    JavascriptExecutor js;
 
    @FindBy(xpath = "//button[contains(@class,'navbar-toggle') or contains(@class,'btn-navbar') or .//i[contains(@class,'fa-bars')]]")
    WebElement navToggle;
 
    @FindBy(xpath = "//div[contains(@class,'navbar-ex1-collapse')]")
    WebElement collapsedMenuContainer;
 
    @FindBy(xpath = "//div[contains(@class,'navbar-ex1-collapse')]//a[normalize-space()='Desktops']")
    WebElement desktopsCollapsed;
 
    @FindBy(xpath = "//a[normalize-space()='Desktops']")
    WebElement desktopsAny;
 
    @FindBy(xpath = "//div[contains(@class,'navbar-ex1-collapse')]//a[contains(@href,'path=20_27') and contains(normalize-space(),'Mac')]")
    WebElement macCollapsed;
 
    @FindBy(xpath = "//a[contains(@href,'path=20_27') and contains(normalize-space(),'Mac')]")
    WebElement macAny;
 
    @FindBy(id = "input-sort")
    WebElement sortByDropdown;
 
    @FindBy(name = "search")
    WebElement topSearchBox;
 
    @FindBy(xpath = "//div[contains(@class,'input-group')]/span/button")
    WebElement topSearchButton;
 
    @FindBy(id = "input-search")
    WebElement advSearchInput;
 
    @FindBy(name = "description")
    WebElement advSearchDescCheck;
 
    @FindBy(id = "button-search")
    WebElement advSearchSubmit;
 
    public void Lab11_PageFactory_2(WebDriver driver2) {
        this.driver = driver2;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.actions = new Actions(driver);
        this.js = (JavascriptExecutor) driver;
    }
 
    public void faBar() {
        try {
            if (!isMenuOpen()) {
                wait.until(ExpectedConditions.elementToBeClickable(navToggle)).click();
                wait.until(d -> isMenuOpen());
            }
        } catch (Exception ignored) {}
    }
 
    public void clickDesktop() {
        ensureMenuReady();
        try {
            WebElement el = visibleOr(desktopsCollapsed, desktopsAny);
            safeClick(el);
        } catch (Exception e) {
            driver.navigate().to("https://tutorialsninja.com/demo/index.php?route=product/category&path=20");
        }
    }
 
    public void clickMac() {
        ensureMenuReady();
        try {
            WebElement el = visibleOr(macCollapsed, macAny);
            safeClick(el);
        } catch (Exception e) {
            driver.navigate().to("https://tutorialsninja.com/demo/index.php?route=product/category&path=20_27");
        }
        wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("path=20_27"),
                ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(.,'Mac')]"))
        ));
    }
 
    public void clickSort() {
        wait.until(ExpectedConditions.elementToBeClickable(sortByDropdown)).click();
    }
 
    public void clickSortSelect() {
        wait.until(ExpectedConditions.visibilityOf(sortByDropdown));
        new Select(sortByDropdown).selectByVisibleText("Name (Z - A)");
    }
 
    public void clickChild() {
        By firstTile = By.xpath("(//div[contains(@class,'product-layout')])[1]");
        WebElement tile = wait.until(ExpectedConditions.visibilityOfElementLocated(firstTile));
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", tile);
    }
 
    public void clickCart() {
        By addOnclick = By.xpath("(//div[contains(@class,'product-layout')])[1]//button[contains(@onclick,'cart.add')]");
        By addText = By.xpath("(//div[contains(@class,'product-layout')])[1]//button[.//span[normalize-space()='Add to Cart'] or normalize-space()='Add to Cart']");
        try {
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(addOnclick));
            jsClick(btn);
            return;
        } catch (Exception ignored) {}
        WebElement btn2 = wait.until(ExpectedConditions.elementToBeClickable(addText));
        jsClick(btn2);
    }
 
    public void clickSearch() {
        WebElement sb = wait.until(ExpectedConditions.elementToBeClickable(topSearchBox));
        sb.click();
    }
 
    public void clickInnerBox() {
        wait.until(ExpectedConditions.elementToBeClickable(topSearchButton)).click();
        wait.until(ExpectedConditions.urlContains("route=product/search"));
    }
 
    public void forCursor() {
        wait.until(ExpectedConditions.elementToBeClickable(advSearchInput)).click();
    }
 
    public void textEnter() {
        WebElement in = wait.until(ExpectedConditions.elementToBeClickable(advSearchInput));
        in.clear();
        in.sendKeys("Mobile");
    }
 
    public void descrip() {
        WebElement cb = wait.until(ExpectedConditions.elementToBeClickable(advSearchDescCheck));
        if (!cb.isSelected()) cb.click();
    }
 
    public void ent() {
        wait.until(ExpectedConditions.elementToBeClickable(advSearchSubmit)).click();
    }
 
    private boolean isMenuOpen() {
        try {
            String cls = collapsedMenuContainer.getAttribute("class");
            return cls != null && (cls.contains("in") || cls.contains("show") || collapsedMenuContainer.isDisplayed());
        } catch (Exception e) {
            return false;
        }
    }
 
    private void ensureMenuReady() {
        try {
            if (!isMenuOpen()) faBar();
            wait.until(ExpectedConditions.visibilityOf(collapsedMenuContainer));
        } catch (Exception ignored) {}
    }
 
    private WebElement visibleOr(WebElement primary, WebElement fallback) {
        try {
            wait.until(ExpectedConditions.visibilityOf(primary));
            return primary;
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOf(fallback));
            return fallback;
        }
    }
 
    private void safeClick(WebElement el) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(el)).click();
        } catch (Exception e) {
            jsClick(el);
        }
    }
 
    private void jsClick(WebElement el) {
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", el);
        js.executeScript("arguments[0].click();", el);
    }
}
