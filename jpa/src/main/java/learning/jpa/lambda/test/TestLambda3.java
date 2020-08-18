package learning.jpa.lambda.test;

import learning.jpa.lambda.bean.Item;
import learning.jpa.lambda.service.impl.*;
import org.junit.Test;

import java.util.function.Consumer;

/**
 * @Classname TestLambda3
 * @Description TODO
 * @Date 2020/8/17 9:29 上午
 * @Author z7-x
 */
public class TestLambda3 {

    /**
     * @param
     * @Description: 方法 testFunctionalInterface 的功能描述：1、Lambda 基础语法
     * @Return void
     * @Author z7-x
     * @Date 2020/8/17 10:03 上午
     */
    @Test
    public void testFunctionalInterface() {
        NoReturnMultiParam noReturnMultiParam = (int a, int b) -> {
            System.out.println("多参数无返回" + (a + b));
        };
        noReturnMultiParam.method(1, 2);

        NoReturnNoParam noReturnNoParam = () -> System.out.println("无参数，无返回值");
        noReturnNoParam.method();

        NoReturnOneParam noReturnOneParam = (int a) -> System.out.println("一个参数无返回" + a);
        noReturnOneParam.method(1);

        ReturnMultiParam returnMultiParam = (int a, int b) -> {
            return (a + b);
        };
        returnMultiParam.method(1, 2);

        ReturnNoParam returnNoParam = () -> {
            return 1;
        };
        returnNoParam.method();

        ReturnOneParam returnOneParam = (int a) -> {
            return a;
        };
        returnOneParam.method(1);
    }

    /**
     * @param
     * @Description: 方法 testLambdaGrammarSimplified 的功能描述：2、Lambda 语法简化
     * @Return void
     * @Author z7-x
     * @Date 2020/8/17 10:04 上午
     */
    @Test
    public void testLambdaGrammarSimplified() {
        //1.简化参数类型，可以不写参数类型，但是必须所有参数都不写
        NoReturnMultiParam noReturnMultiParam = (a, b) -> {
            System.out.println("多参数无返回" + (a + b));
        };
        noReturnMultiParam.method(3, 3);

        //2.简化参数小括号，如果只有一个参数则可以省略参数小括号
        NoReturnOneParam noReturnOneParam = a -> System.out.println("一个参数无返回" + a);
        noReturnOneParam.method(3);

        //3.简化方法体大括号，如果方法条只有一条语句，则可以省略方法体大括号
        NoReturnNoParam noReturnNoParam = () -> System.out.println("简化方法体大括号");
        noReturnNoParam.method();

        //4.如果方法体只有一条语句，并且是 return 语句，则可以省略方法体大括号
        ReturnOneParam returnOneParam = a -> a + a;
        returnOneParam.method(3);
    }

    /**
     * @param
     * @Description: 方法 testCase 的功能描述：3、Lambda 表达式引用方法
     * 语法: 方法归属者(类名/对象名)::方法名 静态方法的归属者为类名，普通方法归属者为对象
     * @Return void
     * @Author z7-x
     * @Date 2020/8/17 4:34 下午
     */
    @Test
    public void testCaseMethod1() {
        //lambda2 引用了已经实现的 doubleNum 方法
        ReturnOneParam lambda2 = Method::doubleNum;  //类::方法
        System.out.println(lambda2.method(3));

        Method method = new Method();

        //lambda4 引用了已经实现的 addTwo 方法
        ReturnOneParam lambda4 = method::addTwo; //对象::方法
        System.out.println(lambda4.method(2));
    }

    static class Method {
        /**
         * 要求
         * 1.参数数量和类型要与接口中定义的一致
         * 2.返回值类型要与接口中定义的一致
         */
        public static int doubleNum(int a) {
            return a * 2;
        }

        public int addTwo(int a) {
            return a + 2;
        }
    }

    /**
     * @param
     * @Description: 方法 testCase 的功能描述：3、Lambda 构造方法的引用
     * 语法:  类名::new 的方式来实例化对象，然后调用方法返回对象
     * @Return void
     * @Author z7-x
     * @Date 2020/8/17 4:34 下午
     */
    @Test
    public void testCaseMethod2() {
        ItemCreatorBlankConstruct itemCreatorBlankConstruct = () -> new Item();  //Lambda表达式引用方式
        Item item = itemCreatorBlankConstruct.getItem();
        System.out.println(item);

        ItemCreatorBlankConstruct itemCreatorBlankConstruct1 = Item::new;  //构造器的引用方式
        Item item1 = itemCreatorBlankConstruct1.getItem();
        System.out.println(item1);

        ItemCreatorParamConstruct itemCreatorParamConstruct = Item::new;
        Item item2 = itemCreatorParamConstruct.getItem(1, "鼠标", 79.00);
        System.out.println(item2);
    }

    /**
     * @param
     * @Description: 方法 testThread 的功能描述：lambda 表达式创建线程
     * @Return void
     * @Author z7-x
     * @Date 2020/8/17 5:30 下午
     */
    @Test
    public void testThread() {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(2 + ":" + i);
            }
        });
        t.start();
    }

    /**
     * @param
     * @Description: 方法 packageProblem 的功能描述：Lambda 表达式中的闭包问题
     * 这个问题我们在匿名内部类中也会存在，如果我们把注释放开会报错，告诉我 num 值是 final 不能被改变。
     * 这里我们虽然没有标识 num 类型为 final，但是在编译期间虚拟机会帮我们加上 final 修饰关键字。
     * @Return void
     * @Author z7-x
     * @Date 2020/8/17 5:56 下午
     */
    @Test
    public void packageProblem() {
        int num = 10;
        Consumer<String> consumer = ele -> System.out.println("" + num);
        //num = num + 2;
        consumer.accept("hello");
    }
}
