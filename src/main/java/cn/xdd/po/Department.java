package cn.xdd.po;

/**
 * @author xchb
 * @version 1.0
 * @ClassName Department
 * @description null
 * @createTime 2019年09月14日 11:52
 */
public class Department {
    private long id;
    private String name;
    private int identifier;
    private int minister_identifier;

    public Department() {
    }

    public Department(long id, String name, int identifier, int minister_identifier) {
        this.id = id;
        this.name = name;
        this.identifier = identifier;
        this.minister_identifier = minister_identifier;
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

    public int getMinister_identifier() {
        return minister_identifier;
    }

    public void setMinister_identifier(int minister_identifier) {
        this.minister_identifier = minister_identifier;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", identifier=" + identifier +
                ", minister_identifier=" + minister_identifier +
                '}';
    }
}
