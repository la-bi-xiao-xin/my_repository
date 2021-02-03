package homework;
/*
第一题: 通过代码, 完成如下需求:
        1. 自定义一个学生类，给出成员变量name和age.
        2. 使用HashSet集合存储学生对象并遍历.
        3. 最后在控制台输出学生对象的成员变量值。
           格式为: 姓名: 张三, 年龄: 23
        4. 通过两种方式遍历.
           提示: 普通迭代器, 增强for.
*/

import java.util.HashSet;
import java.util.Iterator;

public class Demo_01 {
    public static void main(String[] args) {
        // 1.. 使用HashSet集合.
        HashSet<Student> hashSet = new HashSet<>();   //此处容易忘改泛型类型

        //2.创建学生对象
        Student s1 = new Student("张三", 18);
        Student s2 = new Student("李四", 19);
        Student s3 = new Student("王五", 20);
        Student s4 = new Student("赵强", 16);

        //3.在集合中添加Student对象
        hashSet.add(s1);
        hashSet.add(s2);
        hashSet.add(s3);
        hashSet.add(s4);

        //4.遍历集合
        //4.1增强for遍历集合
        for (Student stu : hashSet)
            System.out.println(stu);
        System.out.println("***********************************");

        //4.2迭代器遍历
        Iterator<Student> it = hashSet.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }
}
