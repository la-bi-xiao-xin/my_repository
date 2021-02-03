package homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/*
第三题: 通过代码, 完成如下需求:
        1. 自定义一个人类，给出成员变量name和age.
        2. 使用ArrayList集合存储人类对象并遍历.
        3. 最后在控制台输出人类对象的成员变量值。
        //格式为: 姓名: 张三, 年龄: 23
        4. 通过四种方式遍历.
//提示: 普通迭代器, 增强for, 列表迭代器, 普通for
*/
public class Demo_03 {
    public static void main(String[] args) {
        //1.创建ArrayList集合对象
        ArrayList<Student> arrayList = new ArrayList<>();
        //2.创建Studentd类对象
        Student s1 = new Student("张三", 23);
        Student s2 = new Student("李四", 24);
        Student s3 = new Student("王五", 25);

        //3.将Student类对象添加至集合中
        arrayList.add(s1);
        arrayList.add(s2);
        arrayList.add(s3);

        //控制台输出学生对象的成员变量值。
        //格式为: 姓名: 张三, 年龄: 23
        //修改Student类默认的toString()方法,得到要求格式_姓名: 张三, 年龄: 23
        System.out.println(arrayList);
        System.out.println("************************************");

        //4.通过四种方式遍历:普通迭代器, 增强for, 列表迭代器, 普通for
        //4.1 通过普通迭代器进行遍历
        Iterator<Student> iterator1 = arrayList.iterator();
        while (iterator1.hasNext())
            System.out.println(iterator1.next());
        System.out.println("************************************");

        //4.2 通过列表迭代器进行遍历
        ListIterator<Student> iterator2 = arrayList.listIterator(); //列表迭代器可用于解决并发修改异常
        while (iterator2.hasNext())
            System.out.println(iterator2.next());
        System.out.println("************************************");

        //4.3 通过普通for进行遍历
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        System.out.println("************************************");

        //4.3 通过增强for进行遍历
        for(Student s4:arrayList)
            System.out.println(s4);

    }
}
