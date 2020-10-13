package learning.features.optional.service.impl;

/**
 * @Classname MyFun
 * @Description TODO
 * @Date 2020/8/26 9:41 上午
 * @Author z7-x
 */
public interface MyFun {

    default String getName() {
        return "哈哈哈";
    }
}
