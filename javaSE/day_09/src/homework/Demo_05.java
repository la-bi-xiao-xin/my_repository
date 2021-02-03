package homework;

import java.util.Calendar;
import java.util.Scanner;

//5. 提示用户录入年份, 计算该年的2月有多少天, 并将结果打印到控制台上.
public class Demo_05 {
    public static void main(String[] args) {
        //创建Scanner对象接受年份
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年份");
        int year = sc.nextInt();
        Calendar c = Calendar.getInstance();
        c.set(year, 2, 1);
        c.add(c.DAY_OF_MONTH, -1);
        System.out.println(year + "年2月有" + c.get(c.DAY_OF_MONTH) + "天");
    }
}
