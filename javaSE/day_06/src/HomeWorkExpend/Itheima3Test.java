package HomeWorkExpend;

import java.util.Scanner;

public class Itheima3Test {
    public static void main(String[] args) {
        System.out.println("请输入数组长度");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        Itheima3 itheima3=new Itheima3();
        System.out.println(itheima3.tripleUp(a));
    }
}
