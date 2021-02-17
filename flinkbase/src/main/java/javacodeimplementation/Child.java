package javacodeimplementation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Child extends Parent {
    static Stub childStaticStub = new Stub("child static object log8");

    static {
        System.out.println("child static code execute  log9");
        log.info("child 的静态代码块执行");

    }
    Stub stub;

    public Child() {
        System.out.println("child construtor execute 12");
        stub = new Stub("child constructor create oject log13");
    }

    {
        System.out.println(" child code excute log10");
        log.info("child 的代码块在执行");
    }

    Stub childStub = new Stub("child object log11");





    public void hello(){
        System.out.println("你好,我是child");
    }
}
