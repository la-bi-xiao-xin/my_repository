package HomeWork;
/*
1. 已知有老师和学生都有姓名和年龄, 且都有吃饭的方法, 不同的是: 学生吃牛肉, 老师喝牛肉汤.
   学生要学习study(), 老师要讲课teach(), 请用所学, 模拟该知识.
	*/
/*需求分析:
老师类
成员变量:姓名,年龄
成员方法:吃饭, 讲课

学生类
成员变量:姓名,年龄
成员方法:吃饭, 学习

父类抽取
成员变量:姓名,年龄
成员方法:吃法

*/
//老师类和学生类测试
public class PersonTest {
    public static void main(String[] args) {
        //老师类测试
        //空参测试
        //1.创建老师类对象
        Teacher t=new Teacher();
        //2.调用set()方法 对成员变量进行赋值
        t.setName("李老师");
        t.setAge(35);
        //3.打印成员变量
        System.out.println(t.getName()+"_年龄_"+t.getAge());
        //4.调用成员方法
        t.eat();
        t.techer();
        System.out.println("****************");
        //全参测试
        //1.创建老师类对象,并成员变量初始化
        Teacher t2=new Teacher("王老师",45);
        //2.打印成员变量
        System.out.println(t2.getName()+"_年龄_"+t2.getAge());
        //4.调用成员方法
        t2.eat();
        t2.techer();
        System.out.println("*******************");
        // 学生类类测试
        //空参测试
        //1.1.创建学生类对象
        Student s=new Student();
        //2.调用set()方法 对成员变量进行赋值
        s.setName("张三同学");
        s.setAge(15);
        //3.打印成员变量
        System.out.println(s.getName()+"_年龄_"+s.getAge());
        //4.调用成员方法
        s.eat();
        s.study();
        System.out.println("***********************");
        //全参测试
        //1.创建学生类对对象并初始化成员变量
        Student s2=new Student("李四同学",17);
        //2.打印成员变量
        System.out.println(s2.getName()+"_年龄_"+s2.getAge());
        //3.调用成员方法
        s2.eat();
        s2.study();

    }
}
