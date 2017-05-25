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

    //打开浏览器
    public static WebDriver openBrowser(){
        String dir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", dir + "/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    //关闭浏览器
    public static void closeBrowser(){
        driver.quit();
    }

    //跳转链接并最大化浏览器
    public static void navigate(String url){
        driver.manage().window().maximize();
        driver.get(url);
    }

    //查找单个元素
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

    //查找多个元素
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

    //点击
    public static void click(By by){
        WebElement e = findElement(by);
        e.click();
    }

    //输入文本
    public static void type(By by, String values){
        WebElement e = findElement(by);
        e.clear();
        e.sendKeys(values);
        log.info("type values is : " + values);
    }

    //获取单个文本信息
    public static String getText(By by){
        String text = findElement(by).getText();
        log.info("get text is : " + text);
        return text;
    }

    //获取多个文本信息
    public static ArrayList getTexts(By by){
        ArrayList arrayList = new ArrayList();
        List<WebElement> list = findElements(by);
        for (int i = 0; i < list.size(); i++) {
            String text = list.get(i).getText();
            arrayList.add(text);
            log.info("get texts is : " + text );
        }return arrayList;
    }

    //滚动到指定元素并居中展示
    protected void scrollToElement(By by) {
        WebElement e = findElement(by);
        log.info("scroll view element");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // roll down and keep the element to the center of browser
        js.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", e);
    }

    //移动到指定元素
    public static void moveToElement(By by){
        WebElement e = findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(e).perform();
    }

    //切换到frame
    public static void switchToFrame(By by){
        WebElement f = findElement(by);
        driver.switchTo().frame(f);
    }

    //返回上一个frame
    public static void switchToParFrame(){
        driver.switchTo().parentFrame();
    }

    //跳出frame
    public static void switchToDef(){
        driver.switchTo().defaultContent();
    }

}
