package HomeWork;

import java.util.Scanner;

//9. 定义Demo09类, 在main中调用isEvenNumber()方法, 用来判断数据是奇数还是偶数.
public class zuoye_09 {
    public static void main(String[] args) {
        System.out.println("随机输入一个整数");
        Scanner sc=new Scanner(System.in);
        int a =sc.nextInt();
        isEvenNumber(a);

    }

    /**
     * 此方法用于判断随机整数是奇数还是偶数
     * @param a 需要判断的数
     */
    public static void isEvenNumber(int a) {
        if(a%2==0){
            System.out.println(a+"是一个偶数");
        }else
            System.out.println(a+"是一个奇数");
    }
}
