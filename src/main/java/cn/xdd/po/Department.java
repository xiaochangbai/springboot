package cn.xdd.po;

/**
 * @author xchb
 * @version 1.0
 * @ClassName Department
 * @description 部门实体类
 * @createTime 2019年09月14日 11:52
 */
public class Department {
    private long id;
    private String name;
    private int identifier;
    private int ministerIdentifier;

    public Department() {
    }

    public Department(long id, String name, int identifier, int ministerIdentifier) {
        this.id = id;
        this.name = name;
        this.identifier = identifier;
        this.ministerIdentifier = ministerIdentifier;
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

    public int getMinisterIdentifier() {
        return this.ministerIdentifier;
    }

    public void setMinisterIdentifier(int ministerIdentifier) {
        this.ministerIdentifier = ministerIdentifier;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", identifier=" + identifier +
                ", ministerIdentifier=" + ministerIdentifier +
                '}';
    }
}
