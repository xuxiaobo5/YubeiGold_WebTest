package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import java.io.IOException;


public class ScreenShot extends BasicPage{

    static String path = System.getProperties().getProperty("user.dir") + "/error/";

    public static void screenShot(){
        WebDriver augmentDriver = new Augmenter().augment(driver);
        File file = ((TakesScreenshot)augmentDriver).getScreenshotAs(OutputType.FILE);
        try{
            //根据日期创建文件夹
            //FileManagement fileManagement = new FileManagement();
            //fileManagement.creatFile(path + DateFormat.format(DateFormat.CHECK_LOG_FORMAT));
            FileUtils.copyFile(file, new File(path + DateFormat.format(DateFormat.CHECK_LOG_FORMAT) + "/" +
                    DateFormat.format(DateFormat.DATE_FORMAT) + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
