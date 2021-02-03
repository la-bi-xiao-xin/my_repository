package com.itheima_demo2;

public class  StudentNew extends Persion{
    private int sId;
    private String clas;

    public StudentNew(int sId, String clas) {
        this.sId = sId;
        this.clas = clas;
    }

    public StudentNew(String name, int age, int sId, String clas) {
        super(name, age);
        this.sId = sId;
        this.clas = clas;
    }
    public void study(){
        System.out.println("学习");
    }
}
