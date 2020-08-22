package learning.features.lambda.service.impl;

/**
 * @Classname MyFunctionalInterface<T>
 * @Description TODO
 * @Date 2020/8/16 4:49 下午
 * @Author z7-x
 */
@FunctionalInterface
public interface MyFunctionalInterface<T> {
    //函数式接口，里面只能有一个抽象方法
    boolean test(T t);
}
