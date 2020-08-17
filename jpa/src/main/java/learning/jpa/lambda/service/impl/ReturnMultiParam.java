package learning.jpa.lambda.service.impl;

/**
 * @Classname ReturnMultiParam
 * @Description TODO
 * @Date 2020/8/17 9:19 上午
 * @Author z7-x
 */
@FunctionalInterface
public interface ReturnMultiParam {
    /**多个参数有返回值*/
    int method(int a, int b);
}
