package com.ithema_demo;

public class Teacher extends Person {

    public Teacher() {
    }

    public Teacher(String neme, int age, String gender) {
        super(neme, age, gender);
    }

    @Override
    public void eat() {
        System.out.println("吃教师餐");
    }

    public void teach(){
        System.out.println("我在教课");
    }
}
