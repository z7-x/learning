package learning.features.optional.test;

import learning.features.optional.service.SubClass;
import learning.features.optional.service.impl.MyFun;
import learning.features.optional.service.impl.MyInterface;
import org.junit.Test;

/**
 * @Classname TestDefaultMethod
 * @Description TODO
 * @Date 2020/8/26 9:34 上午
 * @Author z7-x
 */
public class TestDefaultMethod {

    /**
     * 接口默认方法的 "类优先" 原则
     * 若一个接口中定义了一个默认方法，而另一个父类或接口中又定义了一个同名的方法时
     * 1.选择父类中的方法。如果一个父类提供了具体的实现，那么接口中具有相同名称和参数的默认方法会被忽略
     * 2.接口冲突。如果一个父接口提供了一个默认方法，而另一个接口也提供了一个具有相同名称和参数列表的方法（不管方法是否是默认方法），
     * 那么必须覆盖该方法来解决冲突。---->必须实现接口中的方法
     */
    @Test
    public void test1() {
        SubClass subClass = new SubClass();
        String name = subClass.getName();
        System.out.println(name);

        MyInterface.show();//接口.静态方法

    }
}
