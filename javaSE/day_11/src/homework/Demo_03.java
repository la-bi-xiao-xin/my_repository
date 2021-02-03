package homework;

import java.util.Scanner;

/*
第三题: 通过代码, 完成如下需求:
        1. 定义方法getSum(), 用来获取n个整数的和.
        2. 在main方法中调用getSum()方法.
        3. 要求: 通过可变参数实现.
        */
public class Demo_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入求和的数");
        System.out.println(getSum(1, 2, 3, 4, 5));

    }

    //可变参数相当于一个数组
    public static int getSum(int... a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }
}
