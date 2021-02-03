package test;

import mapper.Flyable;

public class FlayTry {
    public static void main(String[] args) {

    useFlable(() ->{
        System.out.println("lambda飞起来");
        return "返回值";
    });


    }

    private static void useFlable(Flyable f){
        String s = f.fly();
        System.out.println(s);
    }
}
