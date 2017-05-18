package pages.background;

import org.openqa.selenium.By;

/**
 * Created by Administrator on 2017/5/17 0017.
 */
public class FrameUtils {

    //定位第一个frame
    public static By leftFrame = By.xpath("//*[@id='main_right' and @class ='page-content']/iframe");

    //定位第二个frame
    public static By rightFrame = By.xpath("//*[@class='page-content']/div/iframe");
}
