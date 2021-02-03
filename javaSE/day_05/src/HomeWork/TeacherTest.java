package HomeWork;

public class TeacherTest {
    public static void main(String[] args) {
        //空参测试
        Teacher t = new Teacher();
        t.setName("刘老师");
        t.setAge(34);
        t.setContent("Java基础中面向对象");
        t.getName();
        t.getAge();
        t.getContent();
        System.out.println(t.getName());
        System.out.println(t.getAge());
        System.out.println(t.getContent());
        System.out.println("*****************");
        //全参测试
        Teacher t2=new Teacher("李老师",32,"Java基础中面向对象");
        System.out.println(t2.getName());
        System.out.println(t2.getAge());
        System.out.println(t2.getContent());
        System.out.println("*******************");
        //成员方法测试
        t.eat();
        t.teach();
        System.out.println("***************");
        t2.eat();
        t2.teach();

    }
}
