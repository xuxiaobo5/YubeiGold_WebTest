package com.yubeigold.web.pages;

import org.openqa.selenium.By;

/**
 * Created by Administrator on 2017/5/17 0017.
 */
public class FrameUtils {

    //定位左侧的frame
    public static By leftFrame = By.xpath("//*[@id='main_right' and @class ='page-content']/iframe");

    //定位右侧的frame
    public static By rightFrame = By.xpath("//*[@class='page-content']/div/iframe");

    //定位输入框的frame
    public static By inputFrame = By.xpath("//*[@class='ui_main']/div/iframe");
}
