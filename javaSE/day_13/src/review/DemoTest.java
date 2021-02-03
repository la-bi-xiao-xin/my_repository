package review;

public class DemoTest {
    public static void main(String[] args) {
        //方式1开启另一方线程执行打印0-99的任务
        Tresd1 tresd1 = new Tresd1("线程1");
        tresd1.start();

        //方式2开启另外一个线程执行打印0-99的任务
        Runable runable = new Runable();
        Thread thread2 = new Thread(runable, "线程2");
        thread2.start();

        //主线程任务打印0-99的数字
        for (int i = 0; i <100 ; i++) {
            System.out.println("主线程执行任务"+i);

        }
    }
}
