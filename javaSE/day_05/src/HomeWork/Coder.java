package HomeWork;
/*属性：
		姓名: name
		工号: id
		工资: salary
	行为：
		工作: work()*/
public class Coder {
    //1.成员变量 私有化
    private String name;
    private int id;
    private int salary;
//2.空参构造
    public Coder() {
    }
//3.全参构造
    public Coder(String name, int id, int salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    //set(),get()方法

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public void work(){
        System.out.println("工号为"+id+", 基本工资为"+salary+"的程序员"+name+"正在努力的写着代码.....\t");
    }
}
