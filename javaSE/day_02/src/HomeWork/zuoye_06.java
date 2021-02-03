package HomeWork;

import java.util.Scanner;

/*
6. 分析以下需求，并用代码实现
        1.商场推出幸运抽奖活动，抽奖规则如下：
        (1)键盘录入四位数字(1000-9999的数字),作为顾客的会员卡号
        (2)该会员卡号(键盘录入的四位数字)各位数字之和大于20，则为幸运客户
        2.打印格式如下：
        请输入4位会员卡号：
        3569
        会员卡号3569各位之和为：23
        会员卡号3569是幸运客户

        请输入4位会员卡号：
        1234
        会员卡号3569各位之和：10
        会员卡号3569不是幸运客户
*/
public class zuoye_06 {
    public static void main(String[] args) {
//键盘录入一个4位数
        System.out.println("请输入4位会员卡号");

        while (true){
            Scanner sc=new Scanner(System.in);
            int a=sc.nextInt();
            if(a<1000 || a>9999){
                System.out.println("输入有误,请重新输入一个4位数");
        }else{
                game(a);
                break;
            }

        }


    }

    public static void game(int a) {
        int ge=a%10;
        int shi=a/10%10;
        int bai=a/100%10;
        int qian=a/1000%10;
        int sum=ge+shi+bai+qian;
        if(sum>20){
            System.out.println("会员卡号"+a+"各位数之和为"+sum);
            System.out.println("会员卡号"+a+"是幸运客户");
        }else{
            System.out.println("会员卡号"+a+"各位数之和为"+sum);
            System.out.println("会员卡号"+a+"不是幸运客户");
        }
    }
}
