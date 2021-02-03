package com.ithema_test;
//需求
//1.	定义两个int类型的变量a. b, 初始化值分别为10, 20
//2.	通过三元运算符, 获取变量a和b的最大值.
//3.	将结果(最大值)打印到控制台上.
public class demo_01 {
    public static void main(String[] args) {
        int a=10;
        int b=20;
        int max=a<b?b:a;
        System.out.println(max);
    }
}
