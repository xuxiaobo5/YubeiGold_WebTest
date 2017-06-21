package com.yubeigold.web.utils;

import org.testng.annotations.Test;


public class AssertUtilTest extends BasicPage{

    //测试断言失败截图
    @Test
    public void screenShotTest(){
        openBrowser("http://www.baidu.com");
        AssertUtil.assertEquals("123","456");
        closeBrowser();
    }

}
