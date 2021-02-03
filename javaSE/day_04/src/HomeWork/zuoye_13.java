package HomeWork;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class zuoye_13 {
    public static void main(String[] args) {
        //登入界面
        String daccount = loginInterFace();
        //登入成功后跳入游戏选择界面
        gameSelectFace(daccount);

    }

    public static void gameSelectFace(String daccount) {
        A:while (true) {
            System.out.println(daccount + "你好!欢迎进入游戏选择界面");
            System.out.println("请录入您想玩儿的游戏编号(1~7):");
            System.out.println("游戏1: 数据段求和. ");
            System.out.println("游戏2: 请录入你的考试成绩(1~100), 我来给你发放奖励.");
            System.out.println("游戏3: 录入一个年份, 输出该年的2月份一共有多少天.");
            System.out.println("游戏4: 哈哈, 我们来玩儿一个图形打印游戏吧.");
            System.out.println("游戏5: 请录入一个人的名字, 我们来猜他的体重吧.");
            System.out.println("游戏6: 请录入一个人的名字, 我们来猜他的体重吧.");
            System.out.println("游戏7: 夯哥大课堂, 一位过来人, 送给你的忠告.");
            System.out.println("输入exit退出整个游戏");
            Scanner sc = new Scanner(System.in);
            String getorder = sc.nextLine();
            switch (getorder) {
                case "exit":
                    System.out.println("亲爱的" + daccount + ", 感谢您使用本游戏, 我们下次再会!");
                    break A;     //退出整个游戏.
                case "1":
                    //调用游戏1方法
                    System.out.println("开始玩儿游戏1吧!\r\n");
                    game1();
                    break;
                case "2":
                    //调用游戏2方法
                    System.out.println("开始玩儿游戏2吧!\r\n");
                    game2();
                    break;
                case "3":
                    //调用游戏3方法
                    System.out.println("开始玩儿游戏3吧!\r\n");
                    game3();
                    break;
                case "4":
                    //调用游戏4方法
                    System.out.println("开始玩儿游戏4吧!\r\n");
                    game4();
                    break;
                case "5":
                    //调用游戏5方法
                    System.out.println("开始玩儿游戏5吧!\r\n");
                    game5();
                    break;
                case "6":
                    //调用游戏6方法
                    System.out.println("开始玩儿游戏6吧!\r\n");
                    break;
                case "7":
                    //调用游戏7方法.
                    System.out.println("开始玩儿游戏7吧!");
                    break;
                default:
                    System.out.println("新游戏即将上线, 请您多留意官网信息. 详情请点: www.itcast.cn \r\n");
                    break;


            }
        }
//game6


//game6

    }

    public static void game5() {
        //game5
        System.out.println("游戏说明:录入名字猜体重");
        System.out.println("请输入名字");
        Scanner sc=new Scanner(System.in);
        String name=sc.nextLine();
        Random rand =new Random();
        int weight=rand.nextInt(99)+50;

        while (true){
            System.out.println("请猜他的体重50-150之间");
            int gussWeigth=sc.nextInt();
            if(weight==gussWeigth){
                System.out.println("恭喜你猜对了!");
                break;
            }else if(gussWeigth>weight){
                System.out.println("你猜大了");
            }else {
                System.out.println("你猜小了");
            }
        }
        System.out.println("恭喜你过关!");
//game5
    }

    public static void game4() {
        //game4
        System.out.println("游戏说明:根据你的幸运数字打印相应乘法表");
        System.out.println("请输入你的幸运数字");
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();
        for (int i = 1; i <=number; i++) {
            for (int j = 1; j <=i; j++) {
                System.out.print(i+"*"+j+"="+i*j+"\t");

            }
            System.out.println();

        }

// game4
    }

    public static void game3() {
        //game3
        System.out.println("游戏说明:获取2月天数");
        System.out.println("请输年份");
        Scanner sc=new Scanner(System.in);
        int year=sc.nextInt();
        if(year%400==0){
            System.out.println(year+"年是闰年2月有29天");
        }else if(year%100!=0 && year%4==0){
            System.out.println(year+"年是平年2月有28天");
        }
        System.out.println("恭喜闯关成功!");
// game3
    }

    public static void game2() {
        //game2
        System.out.println("游戏说明:根据分数发奖品");
        System.out.println("请输入分数");
        Scanner sc=new Scanner(System.in);
        int score=sc.nextInt();
        int a=score/10;
        switch (a){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                System.out.println("奖励作业一堆");
            case 7:
            case 8:
                System.out.println("奖励电影票一张");
            case 9:
                System.out.println("奖励手机一部");
            case 10:
                System.out.println("奖励女朋友一个");
                default:
                    System.out.println("输入分数不再范围内,没有奖励");
        }
        System.out.println("恭喜闯关成功!");
//game2
    }

    public static void game1() {
        //game1
        System.out.println("欢迎来到$数据段求和$游戏");
        System.out.println("游戏说明:录入两个数字, 两个数字间的累加和将会打印到控制台上");
        System.out.println("请输入第1个数字");
        Scanner sc=new Scanner(System.in);
        int number1=sc.nextInt();
        System.out.println("请输入第2个数字");
        int number2=sc.nextInt();
        int sum=0;
        if(number1>=number2){

            for (int i = number2+1; i <number1 ; i++) {
                sum+=i;
            }

        }else{
            for (int i = number1+1; i <number2 ; i++) {
                sum+=i;
            }
        }
        System.out.println(number1+"与"+number2+"数字之间的数字和为:"+sum);
        System.out.println("恭喜闯关成功!");
    }

    public static String loginInterFace() {
        System.out.println("~***欢迎来到黑马游戏***~");
        Scanner sc = new Scanner(System.in);

        String daccount = "admin";
        String dpassword = "itheima123456";

        for (int i = 1; i < 4; i++) {
            System.out.println("请输入帐号");
            String account = sc.nextLine();
            System.out.println("请输入密码");
            String password = sc.nextLine();
            if (i <= 3) {
                if (!daccount.equals(account) || !dpassword.equals(password)) {
                    System.out.println("帐号或密码不正确,请重新输入");
                    System.out.println("你还有" + (3 - i) + "次机会");
                } else {
                    break;
                }

            } else {
                System.out.println("您的帐号已经被锁定");
            }
        }
        return daccount;
    }
}
