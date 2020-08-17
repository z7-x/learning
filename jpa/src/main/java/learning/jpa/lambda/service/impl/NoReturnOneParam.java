package learning.jpa.lambda.service.impl;

/**
 * @Classname NoReturnOneParam
 * @Description TODO
 * @Date 2020/8/17 9:18 上午
 * @Author z7-x
 */
@FunctionalInterface
public interface NoReturnOneParam {
    /**一个参数无返回*/
    void method(int a);
}
