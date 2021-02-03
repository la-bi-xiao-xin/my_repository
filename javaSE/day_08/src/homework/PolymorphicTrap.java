package homework;
/*


        */
public class PolymorphicTrap {
    public static void main(String[] args) {
        A a1 = new A(); //正常创建对象,不解释,对象a1有A类对象的所有属性及方法
        A a2 = new B(); //A类为B类的父类,父类引用指向子类对象,多态创建对象,对象a2只有A类的属性及方法(注意被B类重写A类的方法)
        B b = new B();  //正常创建对象,但B类继承A类,所以对象b有A类和B类所有的属性及方法
        C c = new C();  //正常创建对象,但C类继承B类,且B类继承A类,所以对象c,有A,B,C类的所有属性和方法
        D d = new D();  //正常创建对象,D类继承B类,且B类继承A类,所以对象d有A,B,D类的所有属性及方法
        System.out.println(a1.show(b));
        //a1有A类的show(D obj)方法,需要传入数据类型为D类或D类子类的数据,
        // (为什么传子类也行?答:多态的特性,父类引用可以指向子类对象)
        //a1还有A类的show(A obj)方法,需要传入数据类型为A类或A类子类的数据.
        //方法重载的特性,会根据调用的参数列表来确定实现的具体方法功能
        //此处传入的参数为对象b,因为B类是A类的子类,
        // 所以(a1.show(b)实现的是A类的show(A obj)方法, return ("A and A");
        //打印结果A and A

        System.out.println(a1.show(c));
        //a1有A类的show(D obj)方法,需要传入数据类型为D类或D类子类的数据,
        //a1还有A类的show(A obj)方法,需要传入数据类型为A类或A类子类的数据.
        //方法重载的特性,会根据调用的参数列表来确定实现的具体方法功能
        //此处传入的参数为对象c,因为C类是B类的子类,B类是A类的子类,
        // 所以(a1.show(c)实现的是A类的show(A obj)方法, return ("A and A");
        //打印结果A and A

        System.out.println(a1.show(d));
        //a1有A类的show(D obj)方法,需要传入数据类型为D类或D类子类的数据,
        //a1还有A类的show(A obj)方法,需要传入数据类型为A类或A类子类的数据.
        //方法重载的特性,会根据调用的参数列表来确定实现的具体方法功能
        //此处传入的参数为对象d,因为D类是B类和A的子类,
        // 所以(a1.show(d)实现的是A类的show(D obj)方法, return ("A and D");
        //打印结果A and D

        System.out.println(a2.show(b));
        //a2对象是通过父类A类指向子类B类的多态方式创建的对象,
        // 根据多态的成员方法访问编译看左执行看右和父类引用不能直接访问子类成员方法的特性
        //如果子类不重写方法,a2对象应该只有A类的show(D obj)方法和show(A obj)
        //因为B类中重写了A类的show(A obj)方法
        //a2有A类的show(D obj)方法,需要传入数据类型为D类或D类子类的数据,
        //a2还有B类的show(A obj)方法,需要传入数据类型为A类或A类子类的数据.
        //此处传入的参数为对象b,因为B类是A类的子类,
        // 所以(a2.show(b)实现的是B类的show(A obj)方法, return ("B and A");
        //打印结果B and A

        System.out.println(a2.show(c));
        //a2对象是通过父类A类指向子类B类的多态方式创建的对象,
        // 根据多态的成员方法访问编译看左执行看右和父类引用不能直接访问子类成员方法的特性
        //如果子类不重写方法,a2对象应该只有A类的show(D obj)方法和show(A obj)
        //但因为B类中重写了A类的show(A obj)方法
        //a2有A类的show(D obj)方法,需要传入数据类型为D类或D类子类的数据,
        //a2还有B类的show(A obj)方法,需要传入数据类型为A类或A类子类的数据.
        //此处传入的参数为对象c,因为C类是B的子类,B类是A类的子类
        // 所以(a2.show(c)实现的是B类的show(A obj)方法, return ("B and A");
        //打印结果B and A

        System.out.println(a2.show(d));
        //a2对象是通过父类A类指向子类B类的多态方式创建的对象,
        // 根据多态的成员方法访问编译看左执行看右和父类引用不能直接访问子类成员方法的特性
        //如果子类不重写方法,a2对象应该只有A类的show(D obj)方法和show(A obj)
        //但因为B类中重写了A类的show(A obj)方法
        //a2有A类的show(D obj)方法,需要传入数据类型为D类或D类子类的数据,
        //a2还有B类的show(A obj)方法,需要传入数据类型为A类或A类子类的数据.
        //此处传入的参数为对象d,是一个D类型数据
        // 所以(a2.show(d)实现的是A类的show(D obj)方法,  return ("A and D");;
        //打印结果A and D
        //(疑惑!!!!此处个人觉得,因为的D类也是B类的子类,
        // B类又是A类的子类,传给B类的show(A obj)方法也是可以的,但结果没有访问,为什么呢?)

        System.out.println(b.show(b));
        //b对象是正常创建的对象,但B类继承A类,所以对象b有A类和B类所有的属性及方法
        //b对象有A类的show(D obj)方法和B类的show(B obj),show(A obj)方法
        //b对象有A类的show(D obj)方法,需要传入的数据类型为D类或D类的子类
        //b对象有B类的show(B obj)方法,需要传入的数据类型为B类或B类的子类
        //b对象有B类的show(A obj)方法,需要传入的数据类型为A类或A类的子类
        //此处传入的参数为对象b,调用的是B类的show(B obj)方法,return ("B and B");
        //打印结果B and B

        System.out.println(b.show(c));
        //此处传入的参数为对象c,因为C类是B类的子类
        // 调用的是B类的show(B obj)方法,return ("B and B");
        //打印结果B and B

        System.out.println(b.show(d));
        //此处传入的参数为对象d,调用的是A类的show(D obj)方法, return ("A and D");
        //打印结果A and D
    }
}

class A {
    public String show(D obj) {
        return ("A and D");
    }

    public String show(A obj) {
        return ("A and A");
    }
}

class B extends A {
    public String show(B obj) {
        return ("B and B");
    }
@Override
    public String show(A obj) {
        return ("B and A");
    }
}

class C extends B {
}

class D extends B {
}





