package com.yubeigold.web.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

/**
 * Generate specify random num and Alpha.
 * @author xuxiaobo
 */

public class RandomNum {

    private static LoggerControler log = LoggerControler.getLog(RandomNum.class);

    //生成指定范围的随机数字
    public static int getRangeRandomNum(int min, int max){
        Random r = new Random();
        int num = r.nextInt(max - min + 1) + min;
        log.info(num);
        return num;
    }

    //生成指定长度的随机数字
    public static void getRandomNum(int length){
        String num = RandomStringUtils.randomNumeric(length);
        log.info(num);
    }

    //生成指定长度的随机大小写字母组合
    public static void getRandomAlpha(int length){
        String num = RandomStringUtils.randomAlphabetic(length);
        log.info(num);
    }

    //生成指定长度的随机大小写母和数字组合组合
    public static void getRandomAlpNum(int length){
        String num = RandomStringUtils.randomAlphanumeric(length);
        log.info(num);
    }

}