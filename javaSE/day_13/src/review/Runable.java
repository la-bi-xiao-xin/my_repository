package review;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Runable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <99 ; i++) {
            Thread thread = Thread.currentThread();
            String name = thread.getName();
            System.out.println(name+"执行任务"+i);

        }
    }
}
