package HomeWork;

public class StudentTest {
    public static void main(String[] args) {
        //空参测试
        Student s=new Student();
        s.setName("张三");
        s.setAge(18);
        s.setContent("面向对象");
        System.out.println(s);
        System.out.println(s.getName());
        System.out.println(s.getAge());
        System.out.println(s.getContent());
        System.out.println("**************************");
        //全参测试
        Student s2=new Student("李四",18,"面向对象");
        System.out.println(s2.getName());
        System.out.println(s2.getAge());
        System.out.println(s2.getContent());
        System.out.println("************************");
        //成员方法测试
        s.eat();
        s.study();

    }
}
