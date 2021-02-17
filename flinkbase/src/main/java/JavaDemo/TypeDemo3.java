package JavaDemo;

import java.util.ArrayList;
import java.util.List;
//需求定义一个方法,自能打印数值类型的集合
public class TypeDemo3 {
    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);


        List<Double> doubles = new ArrayList<>();
        doubles.add(1.1);
        doubles.add(1.2);
        doubles.add(1.3);
        doubles.add(1.4);

        List<String> strings = new ArrayList<>();
        strings.add("1");

       print(integers);
       print(doubles);

       //list元素为String类型时报错
      // print(strings);


    }
    //Number 是Double 类型和 Integers 的父类
    //List<? extends Number>表示,集合的元素类型必须为Number或Number的子类
    public static void print(List<? extends Number> list){
        for (Number number : list) {
            System.out.println(number);
        }

    }
}
