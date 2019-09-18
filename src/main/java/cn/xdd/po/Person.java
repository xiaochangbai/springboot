package cn.xdd.po;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;



/**
 * 用户实体类
 * @author xchb
 * @version 1.0
 * @ClassName Person
 * @description 从全局配置文件（classPath路径下的：application.properties或application.yml文件）中获取值的两种方式：
 * 1.在类名上使用@ConfigurationProperties注解,使用prefix属性来设置该类中属性对应配置文件中的对象。
 * 2.在属性中使用@Value注解，设置方式：
 *    （1）字面量（直接赋值）
 *    （2）从配置文件中取值：${配置文件中的key}
 *    （3）SpEL表达式：#{SpEL}。例如；#{1+4}
 *    （4）从自定义配置文件中取出值(需要配合@ConfigurationProperties注解一起使用）：
 *         （4.1）在类上使用@PropertySource注解，value是一个数组类型，可以导入多个配置文件。
 * @createTime 2019年09月07日 20:33
 * 其他注解：
 * @Validated  //进行校验
 * @ConfigurationProperties(prefix = "person")   配置前缀
 * @PropertySource(value = {"classpath:person.properties"})  配置文件
 */
@Component
public class Person {


    /**
     * @Email邮箱校验
     */
    @Value("未知")
    private String name;

    @Value("#{1+8}")
    private Integer age;

    /**
     * @Value("${person.address}")
     */
    private String address;

    private Pets pets;
    private List<Object> hobby;
    private Map<String,Object> teachers;

    public Person(){}

    public Person(String name, Pets pets, List<Object> hobby, Map<String, Object> teachers) {
        this.name = name;
        this.pets = pets;
        this.hobby = hobby;
        this.teachers = teachers;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Pets getPets() {
        return pets;
    }

    public void setPets(Pets pets) {
        this.pets = pets;
    }

    public List<Object> getHobby() {
        return hobby;
    }

    public void setHobby(List<Object> hobby) {
        this.hobby = hobby;
    }

    public Map<String, Object> getTeachers() {
        return teachers;
    }

    public void setTeachers(Map<String, Object> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", pets=" + pets +
                ", hobby=" + hobby +
                ", teachers=" + teachers +
                '}';
    }
}
