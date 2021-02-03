package HomeWork;

import java.util.Scanner;

//10. 定义Demo10类, 在main中调用getMax()方法, 用来获取两个整数的最大值.
//	/*
public class zuoye_10 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入第一个数");
        int a=sc.nextInt();
        System.out.println("请输入第二个数");
        int b=sc.nextInt();
        int max=getMax(a, b);
        System.out.println("较大值为"+max);

    }

    /**
     * 此方法用于比较两数之间的较大值
     * @param a 第一个数
     * @param b 第二个数
     * @return 返回两者之间较大值
     */
    public static int  getMax(int a, int b) {
        int c=a>=b?a:b;
        return c;
    }
}
