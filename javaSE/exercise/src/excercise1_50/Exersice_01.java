package excercise1_50;
/*
2.	题目描述:
        书写一个类，类名为Itheima;
        类中有一个方法，方法名makeBricks;
        我们想做一排砖（长度自己定），我们有一些小砖（每块1英寸）和大砖（每块5英寸），
        如果用我们选择的砖块的数量能够拼接成功，则返回true；否则返回false，
        例如：makeBricks(3, 1, 8) → true
*/

import java.util.Scanner;

public class Exersice_01 {
    public static void main(String[] args) {
        int[] a=new int[3];
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入需要拼接的长度");
        a[0]= sc.nextInt();
        System.out.println("请输入小砖的数量");
        a[1]=sc.nextInt();
        System.out.println("请输入大砖的数量");
        a[2]=sc.nextInt();
        //分解版
       /* boolean result;
        if(a[1]*1>=a[0]){
            result=true;
        }else {
            if (a[0]/5<=a[2] && a[1]>=a[0]%5){
                result=true;
            }else
                result=false;
        }
        System.out.println(result);*/

       //压缩版
        System.out.println(a[1] * 1 >= a[0] ? false : ((a[0] / 5 <= a[2] && a[1] >= a[0] % 5) ? true : false));


    }
}
