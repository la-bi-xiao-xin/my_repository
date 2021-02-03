package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
//
第2题: 通过代码, 完成如下需求:
        1. 循环接收用户键盘输入的多个字符串，直到用户录入“end”时循环结束，
            并将所有已输入的字符串按字典顺序倒序打印。
        2. 按照3个字符串一行的格式输出.
        */
public class Extend_02 {
    public static void main(String[] args) {
        //1.创建集合接收输入的字符串元素
        ArrayList<String> al = new ArrayList<>();

        //2.创建Scanner 对象接收键盘录入对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请开始输入,以end结束输入");
        int count = 0;

        //3.判断录入是否为end字符串,是则不添加,否则将录入字符串添加至集合
        while (true) {
            String s = sc.nextLine();
            if ("end".equals(s)) {
                break;
            } else {
                al.add(s);

            }
        }

        //4.将集合排序
        Collections.sort(al);

        //5.增强for遍历集合,打印结果
        for (String s : al) {
            count++;
            System.out.print(s + " ");
            if (count % 3 == 0)
                System.out.println();
        }
    }
}
