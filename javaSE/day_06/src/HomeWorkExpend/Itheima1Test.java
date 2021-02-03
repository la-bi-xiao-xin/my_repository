package HomeWorkExpend;

import java.util.Scanner;

public class Itheima1Test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请随机输入3个数");
        System.out.println("开始*********");
        System.out.println("请输入第1个数");
        int a=sc.nextInt();
        System.out.println("请输入第2个数");
        int b=sc.nextInt();
        System.out.println("请输入第3个数");
        int c=sc.nextInt();
        Itheima1 itheima=new Itheima1(a,b,c);
       /*
       boolean result=itheima.judge();
        System.out.println(result);
        */
       System.out.println(itheima.judge());
    }
}
