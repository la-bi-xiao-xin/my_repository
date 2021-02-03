package com.ithema_test;
//1.	一座寺庙里住着三个和尚，已知他们的身高分别为150cm、210cm、165cm.
//2.	请用程序实现获取这三个和尚的最高身高。
public class demo_02 {
    public static void main(String[] args) {
        int a=150;
        int b=220;
        int c=165;
//        int temp=a<b?b:a;
//        int max=temp<c?c:temp;
        int max=(a<b?b:a)<c?c:(a<b?b:a);
        System.out.println(max);
    }
}
