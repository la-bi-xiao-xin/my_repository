package review;

public class Tresd1 extends Thread {
    public Tresd1(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i <99 ; i++) {
            String threadName = this.getName();
            System.out.println(threadName+"执行任务"+i);

        }
    }
}
