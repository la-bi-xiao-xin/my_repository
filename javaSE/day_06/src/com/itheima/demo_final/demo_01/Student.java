package com.itheima.demo_final.demo_01;
public class Student  extends Person{
    int age=20;
   // int a=super.age;
public void getAgeAndShow(){
    int age=30;
    System.out.println(age);
    System.out.println(this.age);
    System.out.println(super.age);
    super.show();
}
}
