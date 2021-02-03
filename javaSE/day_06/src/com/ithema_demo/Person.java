package com.ithema_demo;

public class Person {
    private String neme;
    private  int age;
    private String gender;

    public Person() {
        System.out.println("person 空参构造");
    }

    public Person(String neme, int age, String gender) {
        this.neme = neme;
        this.age = age;
        this.gender = gender;
        System.out.println("person 全参构造");
    }

    public String getNeme() {
        return neme;
    }

    public void setNeme(String neme) {
        this.neme = neme;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public void eat(){
        System.out.println("吃饭吧");
    }
    public void  sleep(){
        System.out.println("睡觉吧");
    }
}
