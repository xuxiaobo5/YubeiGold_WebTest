package utils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateFormat {

    final static LoggerControler log = LoggerControler.getLog(DateFormat.class);

    final static String COMMON_DATE_FORMAT = "yyyy-MM-dd";

    final static String SHORT_DATE_FORMAT = "yy-MM-dd HH:mm";

    final static String SMALL_DATE_FORMAT = "MM-dd";

    final static String ABC_ORDER_DATE_FORMAT = "yyyy/MM/dd";

    final static String ABC_ORDER_TIME_FORMAT = "HH:mm:ss";

    final static String LOTTERY_PRINTING_TIME_FORMAT = "HH_mm_ss";

    final static String CHECK_LOG_FORMAT = "yyyyMMdd";

    final static String TEN_PAY_DATE_STRING_FORMAT = "yyMMdd";

    final static String REPORT_CSV_FORMAT = "yyyyMMdd_HHmmss";

    final static String ZH_DATE_FORMAT = "yyyy年MM月dd日 HH:mm:ss";

    final static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    final static String DATE_FORMAT = "yyyy-MM-dd HH-mm-ss";

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
