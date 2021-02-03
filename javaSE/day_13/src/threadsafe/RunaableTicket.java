package threadsafe;

public class RunaableTicket implements Runnable{
    private int ticket=100;
    @Override
    public void run() {
        while(ticket>0){
            System.out.println(Thread.currentThread().getName()+"打印出售第"+ticket+"张票");
            ticket--;

        }

    }
}
