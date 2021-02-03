package HomeWork_02;

public class Employee {
    private String name;
    private String workId;
    private int salary;

    public Employee() {
    }

    public Employee(String name, String workId, int salary) {
        this.name = name;
        this.workId = workId;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public void eat(){
        System.out.println("吃饭");
    }
    public void sleep(){
        System.out.println("睡觉");
    }
    public void work(){
        System.out.println("工作");
    }
}
