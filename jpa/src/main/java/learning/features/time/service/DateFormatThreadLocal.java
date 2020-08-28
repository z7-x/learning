package learning.features.time.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname DateFromatThreadLocal
 * @Description TODO
 * @Date 2020/8/27 9:51 上午
 * @Author z7-x
 */
public class DateFormatThreadLocal {
    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {//上锁
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyMMdd");
        }
    };

    public static Date convert(String str) throws ParseException {
        return df.get().parse(str);
    }
}
