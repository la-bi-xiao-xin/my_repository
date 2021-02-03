package com.itheima_demo;

public class Son extends Father{
    public Son() {
    }

    public Son(int age, String name) {
        super(age, name);
    }
/*
    @Override
    public void show() {
        super.show();
    }*/
    @Override
     public void show(){
        System.out.println("重写 show 方法");
    }
}
