package homework;

public class Demo_02_Runnable implements Runnable{
    private static int tickets=100;
    @Override
    public void run() {
        while (true){

            if(tickets<=0){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"正在售出第"+tickets--+"张票");


        }
    }
}
