package HomeWork;
/*属性：
		姓名: name
		工号: id
		工资: salary
		奖金: bonus
	行为：
		工作: work()*/
public class Manager {
    //1.成员变量 私有化
    private String name;
    private int id;
    private int salary;
    private int bonus;
    //2.空参构造
    public Manager(){}
    //3.全参构造
    public Manager(String name,int id,int salary,int bonus){
        this.name=name;
        this.id=id;
        this.salary=salary;
        this.bonus=bonus;
    }
    //4.set(),get()方法

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }
    //5.成员方法
    public void work(){
        System.out.println("工号为"+id+", 基本工资为"+salary+", 奖金为"+bonus+"的项目经理"+name+"正在努力的做着管理工作,分配任务,检查员工提交上来的代码.....");
    }
    //
}
