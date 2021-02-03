package threadsafe;

public class Demo {
    public static void main(String[] args) {
        //开启四个进程
        RunaableTicket runaableTicket = new RunaableTicket();
        Thread thread1 = new Thread(runaableTicket, "窗口1");
        thread1.start();
        Thread thread2 = new Thread(runaableTicket, "窗口2");
        thread2.start();
        Thread thread3 = new Thread(runaableTicket, "窗口3");
        thread3.start();
        Thread thread4 = new Thread(runaableTicket, "窗口4");
        thread4.start();

    }
}
