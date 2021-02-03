package homework;

import java.util.Scanner;

/*
需求3:
        键盘录入一个字符串, 使用程序实现在控制台遍历打印该字符串.
        */
public class Demo_03 {
    public static void main(String[] args) {
        //1.创建Scanner对象接收录入的字符串gas
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入字符串");
        String s=sc.nextLine();
        //2.利用String的charAt()和length()方法对字符串进行遍历
        for (int i = 0; i <s.length(); i++) {
            //我犯的错直接写charAt(i),显示错误,原因是忘了方法调用的格式为 对象名.方法名(参数);
            System.out.println(s.charAt(i));

        }
    }
}
