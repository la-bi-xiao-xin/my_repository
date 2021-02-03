package homework;
/*
2. 多线程模拟卖票.
方式一: 继承Thread类

方式二: 实现Runnable接口
*/
public class Demo_02 {
    public static void main(String[] args) {
       // 方式一: 继承Thread类
        Thread  thread1=new Demo_02_Thread("窗口1");
        thread1.start();
        Thread  thread2=new Demo_02_Thread("窗口2");
        thread2.start();
        Thread  thread3=new Demo_02_Thread("窗口3");
        thread3.start();
        Thread  thread4=new Demo_02_Thread("窗口4");
        thread4.start();

       //方式二: 实现Runnable接口
       /* Demo_02_Runnable runnable=new Demo_02_Runnable();
        Thread thread21=new Thread(runnable,"窗口一");
        thread21.start();
        Thread thread22=new Thread(runnable,"窗口二");
        thread22.start();
        Thread thread23=new Thread(runnable,"窗口三");
        thread23.start();
        Thread thread24=new Thread(runnable,"窗口四");
        thread24.start();*/

    }
}
