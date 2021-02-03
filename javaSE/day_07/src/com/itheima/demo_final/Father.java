package com.itheima.demo_final;

public class Father {
    String name;
    int age;

    public Father() {
    }

    public Father(String name, int age) {
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
    public void show(){
        System.out.println("我是Father show方法");
    }
   // public abstract void eat();
}
