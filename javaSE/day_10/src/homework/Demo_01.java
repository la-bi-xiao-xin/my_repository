package homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
第一题: 通过代码, 完成如下需求:
        1. 自定义一个学生类，给出成员变量name和age.
        2. 使用Collection集合存储学生对象并遍历.
        3. 最后在控制台输出学生对象的成员变量值。
        //格式为: 姓名: 张三, 年龄: 23
        4. 通过两种方式遍历.
        */
//提示: 普通迭代器, 增强for.
public class Demo_01 {
    public static void main(String[] args) {
        //1.创建Collection 对象  第一步由于Collection是一个接口创建对象需要使用多态形式创建
        Collection<Student> coll = new ArrayList<>();
        //2.创建Studentd类对象
        Student s1 = new Student("张三", 23);
        Student s2 = new Student("李四", 24);
        Student s3 = new Student("王五", 25);
        //3.将Student类对象添加至集合中
        coll.add(s1);
        coll.add(s2);
        coll.add(s3);
        //控制台输出学生对象的成员变量值。
        //格式为: 姓名: 张三, 年龄: 23
        //修改Student类默认的toString()方法,得到要求格式_姓名: 张三, 年龄: 23
        System.out.println(coll);
        System.out.println("************************************");
        //4.采用两种方式遍历集合
        //4.1采用增强for遍历集合
        for (Student student : coll) { //student 为接受元素的变量名
            //Student s=student;
            // System.out.println(s);
            System.out.println(student);  //增强循环体内得到是遍历对象的元素
        }
        System.out.println("**************************************");
        //4.2采用普通迭代器进行遍历
        Iterator<Student> it = coll.iterator();
        while (it.hasNext())
            System.out.println(it.next());

    }
}
