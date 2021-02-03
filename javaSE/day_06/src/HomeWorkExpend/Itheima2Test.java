package HomeWorkExpend;

import java.util.Scanner;

public class Itheima2Test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请选择想要拼接长度");
        int c=sc.nextInt();
        System.out.println("请选择想要选择大小砖数量");
        int a=sc.nextInt();
        int b=sc.nextInt();
        Itheima2 itheima2=new Itheima2(a,b,c);
        System.out.println(itheima2.makeBricks());
    }
}
