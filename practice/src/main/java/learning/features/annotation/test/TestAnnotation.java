package learning.features.annotation.test;

import learning.features.annotation.service.MyAnnotation;
import lombok.NonNull;
import org.junit.Test;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Classname TestAnnotation
 * @Description TODO
 * @Date 2020/8/27 3:39 下午
 * @Author z7-x
 */
public class TestAnnotation {

    private @NonNull Object obj;

    /**
     * 重复注解 与 类型注解
     */
    @MyAnnotation("Hello")
    @MyAnnotation("z7")
    public void show(@MyAnnotation("12345678") String str) {

    }

    @Test
    public void test() {
        Class<TestAnnotation> clazz = TestAnnotation.class;
        try {
            Method method = clazz.getMethod("show");
            MyAnnotation[] annotations = method.getAnnotationsByType(MyAnnotation.class);
            Arrays.stream(annotations).forEach(param -> System.out.println(param.value()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}
