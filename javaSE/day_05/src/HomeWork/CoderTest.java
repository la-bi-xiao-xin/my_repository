package HomeWork;

public class CoderTest {
    public static void main(String[] args) {
        //空参测试
        Coder c=new Coder();
        c.setName("张三");
        c.setId(222);
        c.setSalary(10000);
        c.work();
        System.out.println("***********************");
        //全参测试
        Coder c2=new Coder("王五",333,15000);
        c2.work();
    }
}
