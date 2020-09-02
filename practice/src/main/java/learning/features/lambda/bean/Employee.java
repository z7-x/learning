package learning.features.lambda.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname Employee
 * @Description TODO
 * @Date 2020/8/14 5:02 下午
 * @Author z7-x
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String name;
    private Integer age;
    private double salary;

    public Employee(String name) {
        this.name = name;
    }
}
