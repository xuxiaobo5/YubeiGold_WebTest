package utils;

import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/6/20 0020.
 */
public class DateFormatTest {

    //测试时间格式类
    @Test
    public void dateFormatTest(){
        DateFormat.format(DateFormat.DEFAULT_DATE_FORMAT);
    }
}
