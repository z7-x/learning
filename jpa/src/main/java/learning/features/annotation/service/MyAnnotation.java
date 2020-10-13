package learning.features.annotation.service;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

/**
 * @Classname MyAnnotion
 * @Description TODO
 * @Date 2020/8/27 4:13 下午
 * @Author z7-x
 */
@Repeatable(MyAnnotations.class)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, TYPE_PARAMETER})  //TYPE_PARAMETER  类型注解
@Retention(RetentionPolicy.RUNTIME)//生命周期
public @interface MyAnnotation {
    String value() default "z7";
}
