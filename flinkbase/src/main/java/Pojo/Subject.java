package Pojo;

public class Subject{
    int id;
    String name;

    public Subject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Subject() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}