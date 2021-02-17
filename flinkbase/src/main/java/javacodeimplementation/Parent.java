package javacodeimplementation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Parent {

    static Stub parentStaticStub = new Stub("parent static object log2");

    static {
        System.out.println("parent static code execute log3");
        log.info("parent 静态代码块被执行");
    }

    {
        System.out.println("parent code execute log4");
        log.info("parent 代码块被执行");
    }

    Stub parentStub = new Stub("parent object- log5");

    Stub stub;


    public Parent() {
        System.out.println("parent constructor execute log6");
        log.info("parent 构造方法执行");

        stub = new Stub("parent constructor create object log7");
    }

    public void sayHello(){
        System.out.println("你好,我是parent");
    }
}
