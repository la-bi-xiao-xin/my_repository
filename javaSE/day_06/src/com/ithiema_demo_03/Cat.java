package com.ithiema_demo_03;

public class Cat extends Animal {
    private String color;

    public Cat() {
    }

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
    public void catchMouce(){
        System.out.println("猫抓老鼠");
    }
}
