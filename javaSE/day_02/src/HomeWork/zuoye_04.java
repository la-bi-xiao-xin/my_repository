package HomeWork;

import java.util.Scanner;

/*
4. 键盘录入一个int类型的数据
        ,使用三元运算符判断这个数是奇数还是偶数, 并打印结果.
*/
public class zuoye_04 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个整数");
        int a=sc.nextInt();
        System.out.println(a%2==0?"偶数":"奇数");
    }
}
