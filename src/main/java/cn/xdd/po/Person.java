package cn.xdd.po;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Map;

/**
 * @author xchb
 * @version 1.0
 * @ClassName Person
 * @description 从全局配置文件（classPath路径下的：application.properties或application.yml文件）
 *              中获取值的两种方式：
 *                  1.在类名上使用@ConfigurationProperties注解,使用prefix属性来
 *                      设置该类中属性对应配置文件中的对象。
 *                  2.在属性中使用@Value注解，设置方式：
 *                      （1）字面量（直接赋值）
 *                      （2）从配置文件中取值：${配置文件中的key}
 *                      （3）SpEL表达式：#{SpEL}。例如；#{1+4}
 *               从自定义配置文件中取出值(需要配合@ConfigurationProperties注解一起使用）：
 *                   1.在类上使用@PropertySource注解，value是一个数组类型，可以导入多个配置文件。
 *
 *
 *
 * @createTime 2019年09月07日 20:33
 */

@Component
@ConfigurationProperties(prefix = "person")
//@Validated
@PropertySource(value = {"classpath:person.properties"})
public class Person {

    //@Value("未知")
    //@Email
    private String name;

    @Value("#{1+8}")
    private Integer age;
    @Value("${person.address}")
    private String address;
    private Pets pets;
    private List<Object> hobby;
    private Map<String,Object> teachers;

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
