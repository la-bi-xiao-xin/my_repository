package Demo;

import java.lang.reflect.Constructor;

//通过反射创建对象
public class Demo_03 {
    public static void main(String[] args) throws Exception {
        //1.通过全类名创建Class对象
        Class<?> clazz=Class.forName("Demo.Student");

        //2.通过Student类的Class对象获取反射构造方法
        Constructor<?> con= clazz.getDeclaredConstructor(String.class, int.class);

        //3.通过反射构造方法创建对象
        Student s=(Student)con.newInstance("赵丽颖",28);
        System.out.println(s);




    }
}
