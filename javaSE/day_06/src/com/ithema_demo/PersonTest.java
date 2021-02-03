package com.ithema_demo;

public class PersonTest {
    public static void main(String[] args) {
        //teacher类测试
        //空参测试
        //1.创建Teacher对象
        Teacher t = new Teacher();
        //2.成员变量赋值
        t.setNeme("张三老师");
        t.setAge(37);
        t.setGender("男");
        //3.成员方法调用
        System.out.println(t.getNeme()+"---"+t.getAge()+"---"+t.getGender());
        t.eat();
        t.teach();
        t.sleep();
        System.out.println("**********************");
        //全参类测试
        //1.创建对象,并给成员变量赋值
        Teacher t2=new Teacher("李丽老师",28,"女");
        //2.成员方法调用
        System.out.println(t2.getNeme()+"---"+t2.getAge()+"---"+t2.getGender());
        t2.eat();
        t2.teach();
        t2.sleep();
        System.out.println("*******************");
        //student类测试
        //空参测试
        //1.创建Student对象
        Student s=new Student();
        //2.成员变量赋值
        s.setNeme("王五");
        s.setAge(17);
        s.setGender("男");
        //3.成员方法调用
        s.getNeme();
        s.getAge();
        s.getGender();
        System.out.println(s.getNeme()+"---"+s.getAge()+"---"+s.getGender());
        s.eat();
        s.study();
        s.sleep();
        System.out.println("*******************");
        //全参类测试
        //1.创建对象,并给成员变量赋值
        Student s2=new Student("赵四",19,"男");
        // 2.成员方法调用
        System.out.println(s2.getNeme()+"---"+s2.getAge()+"---"+s2.getGender());
        s2.eat();
        s2.study();
        s2.sleep();
    }
}
