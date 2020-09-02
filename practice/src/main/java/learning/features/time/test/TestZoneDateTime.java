package learning.features.time.test;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Set;

/**
 * @Classname TestZoneDateTime
 * @Description TODO
 * @Date 2020/8/27 2:57 下午
 * @Author z7-x
 */
public class TestZoneDateTime {
    /**
     * 带时区处理
     * ZoneDate
     * ZoneTime
     * ZoneDateTime
     */
    @Test
    public void test1(){
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();//获取所有时区
        availableZoneIds.forEach(System.out::println);

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Pacific/Majuro"));
        System.out.println(now);

    }
}
