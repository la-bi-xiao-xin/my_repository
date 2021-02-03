package HomeWork;

import java.util.Scanner;

//8. 定义Demo08类, 在main中调用getSum()方法, 用来获取两个整数的和.
public class zuoye_08 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入第一个数");
        int a=sc.nextInt();
        System.out.println("请输入第二个数");
        int b = sc.nextInt();
        int sum=getSum(a, b);
        System.out.println("两数之和为:"+sum);
    }

    /**
     * 此方法用于求两数之和
     * @param a 第一个数
     * @param b 第二个数
     * @return 返回两数之和
     */
    public static int getSum(int a, int b) {
        int sum=a+b;
        return  sum;
    }
}
