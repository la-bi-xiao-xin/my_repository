package HomeWork;

import java.util.Scanner;

//10. 某人想买车，没什么车决定于此人在银行有多少存款(键盘录入)。
/*
    如果此人的存款超过500万，则买奥迪A8L；
    否则，如果此人的存款超过100万，则买奥迪A6L；
    否则，如果此人的存款超过50万，则买奥迪A4L；
    否则，如果此人的存款超过10万，则买大众速腾；
    否则此人买大众捷达。
*/
public class zuoye_10 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入银行存款");
        int a=sc.nextInt();
        if(a>=5000000){
            System.out.println("买奥迪A8L");
        }else if(a>=1000000 && a<5000000){
            System.out.println("买奥迪A6L");
        }else if(a>=500000 && a<1000000){
            System.out.println("买奥迪A4L");
        }else if(a>=100000 && a<500000){
            System.out.println("买大众速腾");
        }else {
            System.out.println("买不起车");
        }
    }
}
