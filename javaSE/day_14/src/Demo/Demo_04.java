package Demo;

import java.lang.reflect.Constructor;

//  案例: 演示通过反射获取类的 私有的带参构造方法, 并创建该类的对象.
public class Demo_04 {
    public static void main(String[] args) throws Exception {
        //1.获取目标类的Class对象
        Class<?> clazz = Class.forName("Demo.Student");

        //2.通过Class对象获取反射构造方法
        Constructor<?> con = clazz.getDeclaredConstructor(String.class);

        //3.反射构造方法创建对象,如果创建的反射构造方法是被私有化的,则需要暴力反射
        con.setAccessible(true);
        Student s=(Student)con.newInstance("女");

        System.out.println(s);

    }
}
