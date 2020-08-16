package learning.jpa.lambda.bean;

/**
 * @Classname Employee
 * @Description TODO
 * @Date 2020/8/14 5:02 下午
 * @Author z7-x
 */
public class Employee {
    private String name;
    private Integer age;
    private double salary;

    public Employee() {
        super();
    }

    public Employee(String name, Integer age, double salary) {
        super();
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
