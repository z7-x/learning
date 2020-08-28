package learning.features.annotation.service;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @Classname MyAnnotion
 * @Description TODO
 * @Date 2020/8/27 4:13 下午
 * @Author z7-x
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)//生命周期
public @interface MyAnnotations {
    MyAnnotation[] value();
}
