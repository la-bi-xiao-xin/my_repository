package homework;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

/*
第四题: 通过代码, 完成如下需求:
        1. 自定义一个学生类，给出成员变量name和age.
        2. 定义ArrayList集合, 用来存储学生对象.
        3. 键盘录入3个学生的信息, 将他们封装成学生对象后, 添加到ArrayList集合中.
        4. 判断集合中是否有姓名叫 刘亦菲 的学生, 如果有,
           就往集合中添加学生对象: 糖糖, 18
        5. 遍历集合. 	//用任意一种方式遍历即可.
        */
public class Demo_04 {
    public static void main(String[] args) {
        //1.创建ArrayList集合对象
        ArrayList<Student> arrayList = new ArrayList<>();
        //2.键盘录入学生信息 创建Studentd类对象
        Scanner sc=new Scanner(System.in);
        System.out.println("请录入学生人数");
        int number=sc.nextInt();
        for (int i = 0; i <number ; i++) {
            System.out.println("请录入第"+(i+1)+"个学生姓名");
            String name=sc.next();
            System.out.println("请录入第"+(i+1)+"个学生年纪");
           int age=sc.nextInt();
            arrayList.add(new Student(name, age)) ;
        }
        System.out.println(arrayList);
        System.out.println("************************************");

        // 3.遍历集合判断集合中是否有姓名叫 刘亦菲 的学生, 如果有,
        //  就往集合中添加学生对象: 糖糖, 18
        Student s1=new Student("糖糖",18);
        ListIterator<Student> iterator = arrayList.listIterator();
        while (iterator.hasNext()){
            if("刘亦菲".equals(iterator.next().getName()))
                iterator.add(s1);
        }
        System.out.println(arrayList);
        System.out.println("************************************");
        //4.增强for遍历集合
        for (Student s5:arrayList)
            System.out.println(s5);
    }
}
