package homework;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

/*
4. 定义工具类DateUtils, 该类有两个方法:
 date2String(), string2Date(), 分别用来格式化, 解析日期.
        在测试类中, 测试上述的两个方法.
        */
public class Demo_04 {
    public static void main(String[] args) throws ParseException {
        //测试public static String date2String(Date d, String pattern){}方法
        //1.创建Date类型数据
        Date dt = new Date();
        String pattern = "yyyy年MM月dd日  HH时mm分ss秒";
        System.out.println(DateUtil.date2String(dt, pattern));
        System.out.println("*********************************");

        //测试public static Date string2Date(String sDate, String pattern){}方法
        Scanner sc = new Scanner(System.in);
        System.out.println("yyyy年MM月dd日");
        String s1 = sc.nextLine();
        String s2 = "yyyy年MM月dd日";
        System.out.println(DateUtil.string2Date(s1, s2));


    }
}
