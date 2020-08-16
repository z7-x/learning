package learning.jpa.lambda.service.impl;

/**
 * @Classname MyPredicate
 * @Description TODO
 * @Date 2020/8/14 6:14 下午
 * @Author z7-x
 */
public interface MyPredicate<T> {

    boolean test(T t);
}
