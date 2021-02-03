package Demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//案例: 演示通过反射获取类的 成员方法, 并使用.
public class Demo_05 {
    public static void main(String[] args) throws Exception {
        //1.通过全类名,创建Student的Class对象
        Class<?> clazz = Class.forName("Demo.Student");
        //2.获取反射构造方法
        Constructor<?> con = clazz.getDeclaredConstructor(String.class, int.class);
        //3.通过反射构造方法创建对象
        Student s = (Student) con.newInstance("张三", 34);

        //4.通过Class对象获取反射方法eat(),注意如果方法是私有的方法需要通过暴力反射获取反射方法的对象

        Method method = clazz.getDeclaredMethod("eat");
        method.setAccessible(true);

        //5.调用反射eat()方法

        Object invoke = method.invoke(s);
        System.out.println(invoke);

        //6.通过反射获取getSum方法
        Method getSum = clazz.getDeclaredMethod("getSum",int.class,String.class);
        //getSum.setAccessible(true);

        //7.调用反射getSum方法
        Object sum = getSum.invoke(s, 12, "liuyif");
        System.out.println(sum);

        //7.反射获取成员变量
        Field name = clazz.getDeclaredField("name");
        //8.暴力反射
        name.setAccessible(true);
        //9.设置反射成员,传入参数是对象,要操作的成员变量的值
        name.set(s,"赵二麻子");
        System.out.println(s);


    }
}
