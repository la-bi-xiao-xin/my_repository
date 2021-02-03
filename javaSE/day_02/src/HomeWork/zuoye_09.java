package HomeWork;

import java.util.Scanner;

/*9. 键盘录入学生考试成绩，判断学生等级:
        90-100	优秀
        80-90	好
        70-80	良
        60-70	及格
        60以下	不及格
尽可能多的用多种思路实现.*/
public class zuoye_09 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入学生成绩");
        int a=sc.nextInt();
        if(a>=90 && a<=100){
            System.out.println("成绩优秀");
        }else if(a>=80 && a<90){
            System.out.println("成绩好");
        }else if(a>=70 && a<80){
            System.out.println("成绩良");
        }else if(a>=60 && a<70){
            System.out.println("成绩及格");
        }else {
            System.out.println("成绩不及格");
        }
    }
}
