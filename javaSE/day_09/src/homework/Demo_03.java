package homework;

import java.util.Scanner;

/*
3. 键盘录入一个纯数字形式的字符串, 中间用, 隔开, 获取该字符串中, 所有的数字之和.
        例如:
        用户录入: 11, 22, 33, 44, 55
        则计算结果为: 165
        */
public class Demo_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请键盘录入一个纯数字形式的字符串, 中间用, 隔开\n" +
                "例如:11, 22, 33, 44, 55");
        String s = sc.nextLine();
        System.out.println("用户录入:"+s);
        String[] arryStr = s.split(", ");
        int[] a = new int[arryStr.length];
        int sum = 0;
        for (int i = 0; i < arryStr.length; i++) {
            Integer i1 = new Integer(arryStr[i]);
            a[i] = i1.parseInt(arryStr[i]);
            sum += a[i];
        }
        System.out.println(" 则计算结果为:"+sum);


    }
}
