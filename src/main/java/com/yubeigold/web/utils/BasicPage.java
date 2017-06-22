package com.yubeigold.web.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Init webdriver.
 * @author xuxiaobo
 */

public class BasicPage {

    private static LoggerControler log = LoggerControler.getLog(BasicPage.class);
    public static WebDriver driver;

    //打开浏览器跳转URL并且最大化窗口
    public static WebDriver openBrowser(String url){
        String dir = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", dir + "/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        return driver;
    }

    //关闭浏览器
    public static void closeBrowser(){
        driver.quit();
    }

    //定位单个元素
    public static WebElement locateElement(By by){
        WebElement element = null;
        try{
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }catch (Exception e){
            log.error("can't locate element : " + by);
            e.printStackTrace();
        }
        element = driver.findElement(by);
        return element;
    }

    //定位多个元素
    public static List<WebElement> locateElements(By by){
        List<WebElement> list = null;
        try{
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        }catch (Exception e){
            log.info("can't locate elements : " + by);
            e.printStackTrace();
        }
        list = driver.findElements(by);
        return list;
    }

    //点击元素
    public static void click(By by){
        WebElement e = locateElement(by);
        e.click();
    }

    //输入文本
    public static void type(By by, String values){
        WebElement e = locateElement(by);
        e.clear();
        e.sendKeys(values);
        log.info("type values is : " + values);
    }

    //获取单个文本信息
    public static String getText(By by){
        String text = locateElement(by).getText();
        log.info("get text is : " + text);
        return text;
    }

    //获取多个文本信息
    public static ArrayList getTexts(By by){
        ArrayList arrayList = new ArrayList();
        List<WebElement> list = locateElements(by);
        for (int i = 0; i < list.size(); i++) {
            String text = list.get(i).getText();
            arrayList.add(text);
            log.info("get texts is : " + text );
        }return arrayList;
    }

    //滚动到指定元素并居中展示
    protected void scrollToElement(By by) {
        WebElement e = locateElement(by);
        log.info("scroll view element");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", e);
    }

    //移动到指定元素
    public static void moveToElement(By by){
        WebElement e = locateElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(e).perform();
    }

    //切换到frame
    public static void switchToFrame(By by){
        WebElement f = locateElement(by);
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
