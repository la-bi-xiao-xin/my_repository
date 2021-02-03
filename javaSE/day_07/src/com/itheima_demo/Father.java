package com.itheima_demo;

public  class Father {
    private int age;
    private String name;

    public Father() {
    }

    public Father(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public  void show(){
        System.out.println("show 方法");
    }
}
