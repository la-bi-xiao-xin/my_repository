package homework;

public class Demo_02_Thread extends Thread{
    private static int tickets=100;
    private static String a;
    public Demo_02_Thread() {
    }
    public Demo_02_Thread(String name) {
        super(name);
    }

    @Override
    public  void run() {
       while (true){
                synchronized (this){
                    if(tickets<=0){
                        break;
                    }
                    System.out.println(this.getName()+"正在售出第"+tickets--+"张票");
                }



       }
    }
}
