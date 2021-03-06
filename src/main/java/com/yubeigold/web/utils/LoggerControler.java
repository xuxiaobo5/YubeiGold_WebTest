package com.yubeigold.web.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Log4J.
 * @author xuxiaobo
 */

public class LoggerControler {

    public static Logger logger = null;
    public static LoggerControler loggerControler = null;

    public static LoggerControler getLog(Class<?> T){
        if (logger == null){
            Properties properties = new Properties();
            try{
                String dir = System.getProperty("user.dir");
                String file = dir + "/log4j.properties";
                InputStream is = new FileInputStream(file);
                properties.load(is);
            }catch (IOException e){
                e.printStackTrace();
            }
            PropertyConfigurator.configure(properties);
            logger = Logger.getLogger(T);
            loggerControler  = new LoggerControler();
        }
        return loggerControler;
    }

    public void debug(Object msg){
        logger.debug(msg);
    }

    public void info(Object msg){
        logger.info(msg);
    }

    public void warn(Object msg){
        logger.warn(msg);
    }

    public void error(Object msg){
        logger.error(msg);
    }
}

