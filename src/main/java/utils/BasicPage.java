package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Administrator on 2017/5/15 0015.
 */

public class BasicPage {

    final static LoggerControler log = LoggerControler.getLog(BasicPage.class);

    public static WebDriver driver;

    public static WebDriver openBrowser(){
        String dir = System.getProperty("user.dir");
        String path = System.setProperty("webdriver.chrome.driver", dir+"/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    public static void navigate(String url){
        driver.manage().window().maximize();
        driver.get(url);
    }

    public static void closeBrowser(){
        driver.quit();
    }

    public static WebElement findElement(By by){
        WebElement element = null;
        try{
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }catch (Exception e){
            log.info("can't find element : " + by);
            e.printStackTrace();
        }
        element = driver.findElement(by);
        return element;
    }

    public static List<WebElement> findElements(By by){
        List<WebElement> list = null;
        try{
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        }catch (Exception e){
            log.info("can't find elements : " + by);
            e.printStackTrace();
        }
        list = driver.findElements(by);
        return list;
    }

    public static void click(By by){
        WebElement e = findElement(by);
        e.click();
    }

    public static void type(By by, String values){
        WebElement e = findElement(by);
        e.clear();
        e.sendKeys(values);
        log.info("type values is : " + values);
    }

    public static String getText(By by){
        String text = findElement(by).getText();
        log.info("get text is : " + text);
        return text;
    }

    protected void scrollToElement(By by) {
        WebElement e = findElement(by);
        log.info("scroll view element");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // roll down and keep the element to the center of browser
        js.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", e);
    }

    public static void moveToElement(By by){
        WebElement e = findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(e).perform();
    }

    public static void switchToFrame(String name){
        driver.switchTo().frame(name);
    }

    public static void switchToFrame(int index){
        driver.switchTo().frame(index);
    }

    public static void switchToFrame(By by){
        WebElement e = driver.findElement(by);
        driver.switchTo().frame(e);
    }

    public static void switchToParFrame(){
        driver.switchTo().parentFrame();
    }

    public static void switchToDef(){
        driver.switchTo().defaultContent();
    }
}
