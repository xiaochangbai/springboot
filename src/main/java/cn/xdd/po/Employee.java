package cn.xdd.po;

import java.io.Serializable;

/**
 * @author xchb
 * @version 1.0
 * @ClassName Employee
 * @description null
 * @createTime 2019年09月14日 11:41
 */
public class Employee implements Serializable {

    private long id;
    private String name;
    private int identifier;
    private String passwd;
    private int gender;
    private int age;
    private String phone;
    private String position;
    private int dep_identifier;

    public Employee() {
    }

    public Employee(long id, String name, int identifier, String passwd, int gender, int age, String phone, String position, int dep_identifier) {
        this.id = id;
        this.name = name;
        this.identifier = identifier;
        this.passwd = passwd;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.position = position;
        this.dep_identifier = dep_identifier;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getDep_identifier() {
        return dep_identifier;
    }

    public void setDep_identifier(int dep_identifier) {
        this.dep_identifier = dep_identifier;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", identifier=" + identifier +
                ", passwd='" + passwd + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", position='" + position + '\'' +
                ", dep_identifier=" + dep_identifier +
                '}';
    }
}
