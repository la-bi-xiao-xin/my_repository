package homework;

public class Demo_01_Thread extends Thread{
    public Demo_01_Thread() {
    }

    public Demo_01_Thread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i <100; i++) {
            System.out.println(this.getName()+"Thred_run****"+i);
        }
    }
}
