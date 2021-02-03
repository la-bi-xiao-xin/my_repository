package com.itheima_demo2;

public class Persion {
    private String name;
    private int age;

   public Persion() {
    }
    public Persion(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void eat(){
        System.out.println("吃饭吧");
    }
    public void  sleep(){
        System.out.println("睡觉吧");
    }
}
