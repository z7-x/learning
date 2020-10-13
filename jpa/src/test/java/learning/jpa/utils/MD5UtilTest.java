package learning.jpa.utils;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Classname MD5UtilTest
 * @Description TODO
 * @Date 2020/8/12 6:43 下午
 * @Author z7-x
 */
class MD5UtilTest {

    public static void main(String[] args) {
        String s = MD5Util.backMD5("123456");
        System.out.println(s);
    }
}