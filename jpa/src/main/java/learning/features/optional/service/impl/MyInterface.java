package learning.features.optional.service.impl;

/**
 * @Classname MyInterface
 * @Description TODO
 * @Date 2020/8/26 10:05 上午
 * @Author z7-x
 */
public interface MyInterface {

    /**
     * @param null
     * @Description: 方法  的功能描述：TODD jdk1.8 在接口可以定义默认方法、静态方法
     * @Return
     * @Author z7-x
     * @Date 2020/8/26 10:30 上午
     */
    default String getName() {
        return "呵呵呵";
    }

    static void show() {
        System.out.println("接口中的静态方法!");
    }
}
