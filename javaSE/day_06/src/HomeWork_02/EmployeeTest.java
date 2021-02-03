package HomeWork_02;
/*
2. 定义项目经理类Manager和程序员类Coder, 他们都有姓名, 工号, 工资属性. 项目经理额外有奖金(bonus)属性.
        他们都要吃饭, 睡觉, 工作. 不同的是, 工作内容不同. 请用所学, 模拟该知识.
        Employee:  员工类
        属性:
        姓名, 工号, 工资
        行为:
        eat(), sleep(), work()
*/
/*需求分析
Manager类
        成员变量:姓名,工号,工资,额外奖金
        成员方法:吃法,睡觉,工作
Coder类
        成员变量:姓名,工号,工资
        成员方法:吃法,睡觉,工作
父类抽取
Employee类
        成员变量:姓名,工号,工资属性
        成员方法:吃法,睡觉,工作

*/
public class EmployeeTest {
    public static void main(String[] args) {
        //经理类类测试
        //空参测试
        //1.创建经理类
        Manager m=new Manager();
        //2.set()方法设置成员变量
        m.setName("王经理");
        m.setWorkId("1234");
        m.setSalary(22000);
        m.setBonus(3000);
        //3.打印成员变量
        System.out.println(m.getName()+"_工号_"+m.getWorkId()+"_工资_"+m.getSalary()+"_奖金_"+m.getBonus());
        //4.调用成员方法
        m.eat();
        m.work();
        m.sleep();
        System.out.println("*************************");
        //全参测试
        //1.创建经理类对象并初始化成员变量
        Manager m2=new Manager("李经理","3456",23000,4000);
        //2.打印成员变量
        System.out.println(m2.getName()+"_工号_"+m2.getWorkId()+"_工资_"+m2.getSalary()+"_奖金_"+m2.getBonus());
        //3.调用成员方法
        m2.eat();
        m2.work();
        m2.sleep();
        System.out.println("*************************");
        //程序员类测试
        //空参测试
        //1.创建Coder类对象
        Coder c=new Coder();
        //2.调用set()方法设置成员变量
        c.setName("王二麻子");
        c.setSalary(16000);
        c.setWorkId("6789");
        //3.打印成员变量
        System.out.println(c.getName()+"_工号_"+c.getWorkId()+"_工资_"+c.getSalary());
        //4.调用成员方法
        m.eat();
        m.work();
        m.sleep();
        System.out.println("*************************");

        //全参测试
        //1.创建经理类并初始化成员变量
        Coder c2=new Coder("张建国","3526",17800);
        //2.打印成员变量
        System.out.println(c2.getName()+"_工号_"+c2.getWorkId()+"_工资_"+c2.getSalary());
        //3.调用成员方法
        c2.eat();
        c2.work();
        c2.sleep();

    }
}
