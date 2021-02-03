package Demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //1. 获取Student类的字节码文件对象.
        Class<?> clazz = Class.forName("Demo.Student");

        //2. 通过Student类的 公共的空参构造, 创建Student类的对象.
        Student stu = (Student)clazz.newInstance();

        //3. 通过字节码文件对象, 获取getSum()方法.
        Method method = clazz.getMethod("getSum",int.class, String.class);

        //4. 调用eat()方法
        Object obj = method.invoke(stu, 10, "刘亦菲");
        System.out.println("方法返回值是: " + obj);

    }
}
