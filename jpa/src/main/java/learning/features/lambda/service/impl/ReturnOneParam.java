package learning.features.lambda.service.impl;

/**
 * @Classname ReturnOneParam
 * @Description TODO
 * @Date 2020/8/17 9:27 上午
 * @Author z7-x
 */
@FunctionalInterface
public interface ReturnOneParam {
    /**一个参数有返回值*/
    int method(int a);
}
