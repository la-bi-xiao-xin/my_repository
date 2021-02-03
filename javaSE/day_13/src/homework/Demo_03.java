package homework;

import java.util.concurrent.*;

/*3. 线程池入门.
 public static ExecutorService newFixedThreadPool(int nThreads) 创建线程池, 指定该池子中的线程对象个数.
 线程池接口：ExecutorService
public Future<?> submit(Runnable task)  使用线程池对象方法submit提交线程执行任务，这是实现多线程的第三种方式
方式一: 提交Runnable接口的子类对象.

方式二: 提交Callable接口的子类对象.
*/
public class Demo_03 {
    public static void main(String[] args) {
      /*  //方式一: 提交Runnable接口的子类对象.
        //1. 工厂类创建线程池对象,该池中存储多个线程对象。
        ExecutorService pool = Executors.newFixedThreadPool(5); //父类调用方法创建出子类对象

        //2.提交线程任务
        Future<?> future = pool.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <100; i++) {
                    System.out.println("我是提交的Runnab线程的具体执行代码");
                }

            }
        });
        //pool.shutdown();*/
      //方式二: 提交Callable接口的子类对象.
        //1. 工厂类创建线程池对象,该池中存储多个线程对象。
        ExecutorService pool2=Executors.newFixedThreadPool(5);
        //2.提交线程
        Future<String> future2=pool2.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("我是提交的Callable线程的具体执行代码");
                return "我是线程中执行完返回的数据";
            }
        });
        pool2.shutdown();
        for (int i = 0; i < 100; i++) {
            System.out.println("我是main线程的具体执行代码");
        }

    }
}
