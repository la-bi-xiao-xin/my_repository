package homework;
/*
需求6:	//两种思路: 思路1: String, 思路二: StringBuilder
        1.定义方法reverse(), 实现字符串的反转.
        2.在main方法中键盘录入一个字符串, 调用上述的方法后, 在控制台输出结果.
        3.例如: 键盘录入abc, 输出结果cba.
        提示: 用for循环, 倒序遍历数组, 然后拼接每一个元素即可.
        */

import java.util.Scanner;

public class Demo_06 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入字符串");
        String s=sc.nextLine();
        // 思路1: String
        revese(s);
        System.out.println();
        //思路二: StringBuilder
        StringBuilder sb=new StringBuilder(s);
        System.out.println(sb.reverse());


    }

    public static void revese(String s) {
    /*for (int i = s.length()-1; i <0; i++) {
        System.out.println(s.charAt(i));  执行时跳过了,原因是啥?
        for循环判断条件,没有变,循环变量没有改
        */
        for (int i = s.length()-1; i >=0 ; i--) {
            System.out.print(s.charAt(i));

        }
    }
}

