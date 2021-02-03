package homework;

public class Demo_01_Runnable implements Runnable {
    public Demo_01_Runnable() {
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"Runnable_run" + i);
        }

    }
}
