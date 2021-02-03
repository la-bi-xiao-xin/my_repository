package HomeWork;

import java.util.Scanner;

//8. 键盘录入一个数字, 判断它是否是水仙花数, 并打印结果.
//尽可能多的用多种思路实现.
//提示: 1. 水仙花数是一个3位数.  2. 它的各个位数的立方和等于它本身.
//例如: 153就是一个水仙花数:  153 = 1*1*1 + 5*5*5 + 3*3*3 = 153;
public class zuoye_08 {
    public static void main(String[] args) {
        System.out.println("请输入一个3位数");

        while (true){
            Scanner sc=new Scanner(System.in);
            int a=sc.nextInt();
            if(a<100 || a>999){
                System.out.println("输入不是3位数,请重新输入");
            }else {
                getShuiXianShu(a);
                break;
            }
        }
    }
    public static void getShuiXianShu(int a){
        int ge=a%10;
        int shi=a/10%10;
        int bai=a/100%10;
        if(a==ge*ge*ge+shi*shi*shi+bai*bai*bai){
            System.out.println(a+"是一个水仙花数");
        }else{
            System.out.println(a+"不是一个水仙花数");
        }
    }

}
