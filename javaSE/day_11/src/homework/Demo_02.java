package homework;

import java.util.HashSet;
import java.util.Random;

/*
第二题: 通过代码, 完成如下需求:
        1. 编写一个程序, 获取10个 20~50 之间的随机数.
        //包含20, 50
        2. 要求随机数不能重复, 并将结果打印到控制台上.
        */
public class Demo_02 {
    public static void main(String[] args) {
        //2.创建HashSet集合
        HashSet<Integer> hs = new HashSet<>();

        //3.判断集合长度是否小于等于10,是则添加元素,否则停止添加元素
        while (hs.size() < 10) {
            hs.add(getRandomNumber());
        }
        System.out.println(hs);

    }

    public static int getRandomNumber() {
        //1.编写一个程序, 获取10个 20~50 之间的随机数,包含20, 50
       /* Random random=new Random();
        int number=random.nextInt(31)+20;*/
        int number = new Random().nextInt(31) + 20;
        return number;
    }
}
