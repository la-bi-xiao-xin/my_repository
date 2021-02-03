package homework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
第二题: 通过代码, 完成如下需求:
        1. 自定义一个学生类，给出成员变量name和age.
        2. 使用List集合存储学生对象并遍历.
        3. 最后在控制台输出学生对象的成员变量值。
        //格式为: 姓名: 张三, 年龄: 23
        4. 通过两种方式遍历.
        */
//提示: 普通迭代器, 增强for.
public class Demo_02 {
    public static void main(String[] args) {
        //1.创建List集合对象
        List<Student> list = new ArrayList<>();
        //2.创建Studentd类对象
        Student s1 = new Student("张三", 23);
        Student s2 = new Student("李四", 24);
        Student s3 = new Student("王五", 25);
        //3.将Student类对象添加至集合中
        list.add(s1);
        list.add(s2);
        list.add(s3);
        //控制台输出学生对象的成员变量值。
        //格式为: 姓名: 张三, 年龄: 23
        //修改Student类默认的toString()方法,得到要求格式_姓名: 张三, 年龄: 23
        System.out.println(list);
        System.out.println("************************************");
        //4.采用两种方式遍历集合
        //4.1采用增强for遍历集合
        for(Student st:list)
            System.out.println(st);
        System.out.println("************************************");
        //4.2 采用List集合迭代器遍历
        Iterator<Student> it = list.iterator();
        while(it.hasNext())
            System.out.println(it.next());

    }
}
