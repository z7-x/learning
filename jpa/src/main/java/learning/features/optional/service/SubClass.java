package learning.features.optional.service;

import learning.features.optional.service.impl.MyFun;
import learning.features.optional.service.impl.MyInterface;

/**
 * @Classname SubClass
 * @Description TODO
 * @Date 2020/8/26 9:47 上午
 * @Author z7-x
 */
public class SubClass /**extends  MyClass **/
        implements MyFun, MyInterface {
    @Override
    public String getName() {
        return MyInterface.super.getName();
    }
}
