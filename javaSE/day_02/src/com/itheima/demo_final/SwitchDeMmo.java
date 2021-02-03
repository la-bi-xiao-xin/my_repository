package com.itheima.demo_final;

import java.util.Scanner;

public class SwitchDeMmo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个数字");
        int a=sc.nextInt();

        switch (a){
            case 1:
                System.out.println("1");
            case 2:
                    System.out.println("2");
            case 3:
                System.out.println("3");
                break;
            case 4:
                System.out.println("4");
                break;
                default:
                    System.out.println("defa");
        }
    }
}
