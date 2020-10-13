package learning.features.lambda.service.impl;

/**
 * @Classname MyFunInterface
 * @Description TODO
 * @Date 2020/8/17 6:43 下午
 * @Author z7-x
 */
@FunctionalInterface
public interface MyFunInterface2<T, R> {
    R getValue(T t1, T t2);
}
