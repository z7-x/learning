package learning.features.time.test;

import io.swagger.models.auth.In;
import org.apache.tomcat.jni.Local;
import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @Classname TestLocalDateTime
 * @Description TODO
 * @Date 2020/8/27 10:16 上午
 * @Author z7-x
 */
public class TestLocalDateTime {

    /**
     * LocalDate        表示时间
     * LocalTime        表示日期
     * LocalDateTime    表示时间和日期
     */
    @Test
    public void test1() {
        /**
         * LocalDateTime.now();     获取当前时间日期
         */
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDateTime of = LocalDateTime.of(2020, 9, 10, 12, 59, 59);
        System.out.println(of);

        /**
         * 运算...
         */
        LocalDateTime localDateTime1 = localDateTime.plusYears(2);//+2年
        System.out.println("+2年：" + localDateTime1);

        LocalDateTime localDateTime2 = localDateTime.minusMonths(2);//-2月
        System.out.println("-2月：" + localDateTime2);
    }

    /**
     * Instant      时间戳，以Unix元年 1970年1月1日 0:00:00到某个时间之间的毫秒值
     */
    @Test
    public void test2() {
        Instant instant = Instant.now();//获取UTC时区
        System.out.println(instant);

        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));//偏移量，偏移8小时
        System.out.println(offsetDateTime);

        System.out.println(instant.toEpochMilli());//时间戳

        Instant instant1 = Instant.ofEpochSecond(1000);
        System.out.println(instant1);
    }

    /**
     * Duration: 计算两个时间之间的间隔
     */
    @Test
    public void test3() throws InterruptedException {
        Instant start = Instant.now();
        Thread.sleep(1000);
        Instant end = Instant.now();

        Duration duration = Duration.between(start, end);
        System.out.println(duration.toMillis());

    }

    /**
     * Period: 计算两个日期之间的间隔
     */
    @Test
    public void test4() {
        LocalDate start = LocalDate.of(2018, 1, 1);
        LocalDate end = LocalDate.now();

        Period period = Period.between(start, end);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());

    }

    /**
     * TemporalAdjuster:  时间校正器
     */
    @Test
    public void test5() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(10);//将指定月中的天
        System.out.println(localDateTime1);

        LocalDateTime localDateTime2 = localDateTime.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));//获取当前日期的星期天
        System.out.println(localDateTime2);

        //自定义：下一个工作日
        LocalDateTime localDateTime3 = localDateTime.with(param -> {
            LocalDateTime ldt = (LocalDateTime) param;
            DayOfWeek dayOfWeek = ldt.getDayOfWeek();
            if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
                return ldt.plusDays(3);
            } else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
                return ldt.plusDays(2);
            } else {
                return ldt.plusDays(1);
            }
        });
        System.out.println(localDateTime3);
    }

    /**
     * DateTimeFormatter  格式化时间/日期
     */
    @Test
    public void test6() {
        DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE;
        LocalDateTime now = LocalDateTime.now();

        String format = isoDateTime.format(now);
        System.out.println(format);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时:mm分:ss秒");//格式化日期
        String format1 = formatter.format(now);
        System.out.println(format1);

    }
}
