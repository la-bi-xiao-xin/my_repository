package homework;

import java.util.Scanner;

/*
需求2:
        1.模拟用户登录, 只给3次机会, 登录成功则提示"欢迎您, ***".
        2.登录失败则判断是否还有登录机会, 有则提示剩余登录次数, 没有则提示"您的账号已被锁定".
        3.假设初始化账号和密码分别为: "传智播客", "黑马程序员".
        */
public class Demo_2 {
    public static void main(String[] args) {
        //1.定义字符初始化账号和密码串常量
        String acount="传智播客";
        String passWord="黑马程序员";
        //2.创建Scanner对象录入账号密码
        Scanner sc=new Scanner(System.in);
        for (int i = 0; i <3; i++) {
            System.out.println("请输入账号");
            String a=sc.nextLine();
            System.out.println("请输入密码");
            String pw = sc.nextLine();
            //3.判断录入字符串与初始化值是否相同
            if(acount.equals(a) && passWord.equals(pw)){
                //4.相同则进打印"欢迎您, ***".
                System.out.println("\"欢迎您, "+a+"\"");
                break;
            }else{
                //5.不同则提示登入失败,判断输入次数是否超过3次
                if(i<3){
                    //6.未超过则提示剩余输入次数
                    System.out.println("登入失败,你还有"+(2-i)+"次机会");
                }else
                //7.超过则提示"您的账号已被锁定".
                    System.out.println("\"您的账号已被锁定\"");
            }

        }

    }
}
