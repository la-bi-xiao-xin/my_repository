package HomeWork;

public class ManagerTest {
    public static void main(String[] args) {
        //空参测试
        Manager m = new Manager();
        m.setName("张三");
        m.setId(123);
        m.setSalary(1600);
        m.setBonus(6000);
        m.work();
        System.out.println("******************");
        //全参测试
        Manager m2 = new Manager("李四", 666, 20000, 1000);
        m2.work();
    }
}
