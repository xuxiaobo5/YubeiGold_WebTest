package com.yubeigold.web.utils;

import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/6/20 0020.
 */
public class LoggerControlerTest {

    final static LoggerControler log = LoggerControler.getLog(LoggerControlerTest.class);

    @Test
    public void loggerControlerTest(){
        log.info("This is log test");
    }
}
