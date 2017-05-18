package utils;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class BasicPage {

    final static LoggerControler log = LoggerControler.getLog(BasicPage.class);

    public static WebDriver driver;

    public static WebDriver openBrowser(){
        String dir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", dir + "/drivers/chromedriver.exe");
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

    public static ArrayList getTexts(By by){
        ArrayList arrayList = new ArrayList();
        List<WebElement> list = findElements(by);
        for (int i = 0; i < list.size(); i++) {
            String text = list.get(i).getText();
            arrayList.add(text);
            log.info("get texts is : " + text );
        }return arrayList;
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

    public static void switchToFrame(By by){
        WebElement f = findElement(by);
        driver.switchTo().frame(f);
    }

    public static void switchToFrame(int index){
        driver.switchTo().frame(index);
    }

    public static void switchToFrame1(By by){
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
