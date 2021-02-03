package homework;
//6. 提示用户录入他的出生年月日,
// 计算这个用户一共活了多少天, 并将结果打印到控制台上.

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Demo_06 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你的年份");
        int year=sc.nextInt();
        System.out.println("请输入你的月份");
        int month=sc.nextInt();
        System.out.println("请输入你的日期");
        int day=sc.nextInt();
        Calendar c=Calendar.getInstance();
        c.set(year,month,day);
        System.out.println(c.getTimeInMillis());

        Date dt=new Date();
        System.out.println(dt.getTime());
        long result=(dt.getTime()-c.getTimeInMillis())/1000/60/60/24/365;
        System.out.println("你活了"+result+"年");

    }
}
