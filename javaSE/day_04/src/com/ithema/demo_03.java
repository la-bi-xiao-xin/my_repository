package com.ithema;

import java.util.Scanner;

public class demo_03 {
    public static void main(String[] args) {
        System.out.println("请输入第1个数字");
        Scanner sc=new Scanner(System.in);
        int number1=sc.nextInt();
        System.out.println("请输入第2个数字");
        int number2=sc.nextInt();
        int sum=0;
        if(number1>=number2){

            for (int i = number2+1; i <number1 ; i++) {
                sum+=i;
            }

        }else{
            for (int i = number1+1; i <number2 ; i++) {
                sum+=i;
            }
        }
        System.out.println(number1+"与"+number2+"数字之间的数字和为:"+sum);
    }
}
