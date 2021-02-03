import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool_demo01 {
    public static void main(String[] args) {
        //1. 工厂类创建线程池对象,该池中存储10个线程对象。
        ExecutorService ex = Executors.newFixedThreadPool(10);
        //2. 提交任务
        /*
            上例的线程池对象已经包含了10个线程，线程池提供了submit方法，
            接收不同的线程执行目标类对象，接收到后，线程池会自动分配一个线程执行。
            格式: ex.submit(线程执行目标类对象);
         */
        //这里使用匿名内部类的方式简单演示：

        //单次提交
        ex.submit(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j <100 ; j++) {
                    System.out.println(Thread.currentThread().getName() +  "你好j="+j );
                }


            }
        });

        //多次提交
        for (int i = 0; i < 5; i++) {

            ex.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j <10000 ; j++) {
                        System.out.println(Thread.currentThread().getName() +  "你好j="+j );
                    }


                }
            });
        }

        //3. 销毁线程池.
        ex.shutdown();

    }
}
