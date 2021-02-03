package com.itheima.demo_final;

public class FatherTest {
    public static void main(String[] args) {
        Son son=new Son();
        Son son2=new Son();
        son=son2;
        System.out.println(son);
        System.out.println(son2);
        son.show(1);
        son2.show(2);

    }
}
