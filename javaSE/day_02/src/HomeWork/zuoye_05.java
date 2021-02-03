package HomeWork;

import java.util.Scanner;
/*
5. 提示用户键盘录入学员张浩的3门课程(Java、SQL、Web)的成绩, 编写程序实现如下需求:
        1. 获取Java课程和SQL课程的分数之差, 并打印结果.
        2. 获取3门课程的平均分, 并打印.
*/
public class zuoye_05 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入Java成绩");
        int java=sc.nextInt();
        System.out.println("请输入sql成绩");
        int sql=sc.nextInt();
        System.out.println("请输入web成绩");
        int web=sc.nextInt();
        System.out.println("java与sql成绩只差为:"+(java - sql));
        System.out.println("3门课平均成绩为:"+(java + sql + web) / 3);
    }
}
