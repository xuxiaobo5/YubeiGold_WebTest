package utils;

import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/6/20 0020.
 */
public class RandomNumTest {

    //测试生成指定范围的随机数字
    @Test
    public void getRangeRandomNumTest(){
        RandomNum.getRangeRandomNum(1000,2000);
    }

    //测试生成指定长度的随机数字
    @Test
    public void getRandomNumTest(){
        RandomNum.getRandomNum(13);
    }

    //测试生成指定长度的随机字母
    @Test
    public void getRandomAplhaTest(){
        RandomNum.getRandomAlpha(5);
    }

    //测试生成指定长度的随机数字+字母
    @Test
    public void getRandomAlpNum(){
        RandomNum.getRandomAlpNum(10);
    }
}
