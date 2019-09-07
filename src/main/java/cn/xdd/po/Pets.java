package cn.xdd.po;

/**
 * @author xchb
 * @version 1.0
 * @ClassName Pets
 * @description null
 * @createTime 2019年09月07日 20:34
 */
public class Pets {

    private String name;
    private Integer age;

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

    @Override
    public String toString() {
        return "Pets{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
