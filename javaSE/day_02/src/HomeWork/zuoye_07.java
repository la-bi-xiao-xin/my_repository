package HomeWork;

import java.util.Scanner;

//7. 键盘录入小明左右手牌的点数, 并接收,
// 编写代码实现交换小明手中的牌, 并打印结果.
/*
    //尽可能多的用多种思路实现.
    格式如下:
        请输入小明左手中的纸牌：
        10
        请输入小明右手中的纸牌：
        8
        互换前小明手中的纸牌：
        左手中的纸牌：10
        右手中的纸牌：8

        互换后小明手中的纸牌：
        左手中的纸牌：8
        右手中的纸牌：10
*/
public class zuoye_07 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入小明左手中的纸牌");
        int a=sc.nextInt();
        System.out.println("请输入小明右手中的纸牌");
        int b = sc.nextInt();
        System.out.println("互换前小明手中的纸牌");
        System.out.println("左手中的纸牌"+a);
        System.out.println("右手中的纸牌"+b);
        int temp=a;
        a=b;
        b=temp;
        System.out.println("互换后小明手中的纸牌");
        System.out.println("左手中的纸牌"+a);
        System.out.println("右手中的纸牌"+b);

    }
}
