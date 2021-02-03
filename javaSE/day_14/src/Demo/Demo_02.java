package Demo;

import java.lang.reflect.Constructor;

/*
    案例: 演示通过反射获取类中的构造方法.
    成员变量: Field  构造方法:Constructor  成员方法:Method

    涉及到的API
        Class类中的成员方法:
            public Constructor[] getConstructors();
            根据字节码文件对象, 获取该类中所有的(非私有的)构造方法
            public Constructor getConstructor(Class... clazz);
            根据字节码文件对象, 获取该类中指定的(非私有的)构造方法

            public Constructor[] getDeclaredConstructors();
             根据字节码文件对象, 获取该类中所有的构造方法, 包括私有.
            public Constructor getDeclaredConstructor(Class... clazz);
            根据字节码文件对象, 获取该类中指定的构造方法, 包括私有.

            public T newInstance();
            通过字节码文件对象, 根据获取到的 公共的无参构造, 创建该类的对象.

        Constructor类中的成员方法:
            public T newInstance(Object... params);
            通过构造器对象(就是构造方法的对象形式), 创建该类的对象.
            public void setAccessible(boolean flag);
            传入true, 表示暴力反射, 即: 能访问私有成员.

    目的:
        通过构造方法, 来创建该类的对象.
 */
public class Demo_02 {
    public static void main(String[] args) throws Exception {
        //1.获取Student 类的Class对象
        Class<?> clazz=Class.forName("Demo.Student");

        //2.通过反射获取类的构造方法
        //2.1 public Constructor[] getConstructors();获取所有公共构造方法
        mothed1(clazz);
        System.out.println("********************************");

        //2.2public Constructor getConstructor(Class... clazz);获取指定公共构造方法
        Constructor<?> con = clazz.getConstructor(String.class, int.class);
        System.out.println(con);
        System.out.println("********************************");

        //2.3public Constructor[] getDeclaredConstructors();获取所有的构造方法包括私有的
        Constructor<?>[] cons = clazz.getDeclaredConstructors();
        for (Constructor<?> con2 : cons) {
            System.out.println(con2);

        }
        System.out.println("********************************");

        //2.4 public Constructor getDeclaredConstructor(Class... clazz);获取指定构造方法包括私有的
        Constructor<?> con3 = clazz.getDeclaredConstructor(String.class);
        System.out.println(con3);

    }

    public static void mothed1(Class<?> clazz) {
        // 根据字节码文件对象, 获取该类中所有的(非私有的)构造方法
        Constructor[] cons=clazz.getConstructors();
        for (Constructor con : cons) {
            System.out.println(con);
        }
    }
}
