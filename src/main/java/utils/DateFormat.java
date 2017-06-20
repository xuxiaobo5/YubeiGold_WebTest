package utils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateFormat {

    final static LoggerControler log = LoggerControler.getLog(DateFormat.class);

    final static String ZH_DATE_FORMAT = "yyyy年MM月dd日 HH:mm:ss";

    final static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    final static String COMMON_DATE_FORMAT = "yyyy-MM-dd HH-mm-ss";

    final static String CHECK_LOG_FORMAT = "yyyyMMdd";

    final static String ABC_DATE_FORMAT = "yyyy/MM/dd";

    final static String ABC_TIME_FORMAT = "HH:mm:ss";

    final static String LOTTERY_PRINTING_TIME_FORMAT = "HH_mm_ss";

    //引入SimpleDateFormat类处理时间
    private static SimpleDateFormat simpleDateFormat;

    public static String format(String type) {
        simpleDateFormat = new SimpleDateFormat(type);
        String s = simpleDateFormat.format(new Date());
        log.info(s);
        return s;
    }

    public static long time() {
        long time = System.currentTimeMillis();
        log.info(String.valueOf(time));
        return time;
    }
}
