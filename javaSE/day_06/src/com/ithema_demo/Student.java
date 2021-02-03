package com.ithema_demo;

public class Student extends Person {
    public Student() {
    }

    public Student(String neme, int age, String gender) {
        super(neme, age, gender);
    }

    @Override
    public void eat() {
        System.out.println("吃学生餐");
    }

    public void study(){
        System.out.println("我在学习");
    }
}
