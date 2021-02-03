package homework;

/*
1. main线程输出100次  main....数字,   自定义线程输出100次 run...i.
//方式一: 继承Thread类

//方式二: 实现Runnable接口
*/
public class Demo_01 {
    public static void main(String[] args) {
        //方式一: 继承Thread类
       /* Thread thread1=new Demo_01_Thread("线程一");
        thread1.start();*/

        //方式二: 实现Runnable接口
        Demo_01_Runnable runnable = new Demo_01_Runnable();
        Thread thread2 = new Thread(runnable, "线程二");
        thread2.start();


        for (int i = 0; i < 100; i++) {
            System.out.println("main" + i);
        }

    }
}
