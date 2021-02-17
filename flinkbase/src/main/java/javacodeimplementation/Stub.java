package javacodeimplementation;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Stub {
    public Stub(String str) {
        System.out.println(str + " object create log1");
        log.info("stub 的构造方法被执行");


    }
}
