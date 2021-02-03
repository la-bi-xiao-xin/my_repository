package HomeWork;
//4. 创建Demo03.java文件, 在类中定义主方法, 并在主方法中使用输出语句, 输出如下图形:
/*
 *
 **
 ***
 ****
 */

import java.util.Scanner;

public class zuoye_04 {
    public static void main(String[] args) {
//        调用循环嵌套实现直角三角形状的打印
        /*
        外层循环控制行数,内循环控制列数
        每一行*的列数通过观察可以发现与行数i成对应关系
        */
        for (int i = 1; i <5 ; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print("*");

            }
            System.out.println();

        }
    }

    /*
        5. 提示用户键盘录入学员张浩的3门课程(Java、SQL、Web)的成绩,
        编写程序实现如下需求:
                1. 获取Java课程和SQL课程的分数之差, 并打印结果.
                2. 获取3门课程的平均分, 并打印.
        */
    public static class zuoye_05 {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("请输入Java成绩");
            int java=sc.nextInt();
            System.out.println("请输入SQL成绩");
            int sql=sc.nextInt();
            System.out.println("请输入Web成绩");
            int web=sc.nextInt();
            int def=java-sql;
            System.out.println("Java成绩与SQL成绩只差为:"+def);
            int avg=(java+sql+web)/3;
            System.out.println("3门课成绩的平均分为:"+avg);

        }
    }
}
