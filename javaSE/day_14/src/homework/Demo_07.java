package homework;

import java.lang.reflect.Method;
import java.util.ArrayList;

/*
    案例: 通过反射技术，向一个泛型为Integer的集合中添加一些字符串数据

    细节:
        1. 泛型只在编译期间有效.
        2. 案例思路:
            A. 获取ArrayList集合的字节码文件对象.
            B: 根据字节码文件对象获取add()方法, 将其形参类型修改为 Object类型.
            C: 剩下的, 你说了算.
 */
public class Demo_07 {
    public static void main(String[] args) throws Exception {
        //1.创建ArrayList 集合
        ArrayList<String> al=new ArrayList<>();
        //2.往集合中添加元素
        al.add("张三");
        al.add("李四");
        al.add("王五");
        al.add("赵六");

        //3.尝试往集合中添加非字符串元素
       // al.add(12);报错无法添加

        //4.获取ArrayList类Class对象
        Class<?> clazz = Class.forName("java.util.ArrayList");

        //5.通过反射获取类的成员方法]
        Method addd = clazz.getDeclaredMethod("add",Object.class);
        addd.invoke(al,12);
        for (Object s : al) {
            System.out.println(s);
        }

    }
}
