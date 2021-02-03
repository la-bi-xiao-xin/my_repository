package exercise;

import java.util.Scanner;

//6. 从键盘上录入一个大于100的三位数,求出100到该数字之间满足如下要求的数字之和, 要求如下:
	/*
	1. 数字的个位数不为7;
	2. 数字的十位数不为5;
	3. 数字的百位数不为3;
//	*/
//	while(true) {
//		int num = sc.nextInt();
//		if(num > 100)
//			break;
//		else
//			sop("录入有误, 重新录取");
//	}
//
//	for(int i=100; i <= num; i++) {
//		int ge = i / 1 % 10;
//		...shi
//		...bai
//		if(ge != 7 && shi != 5 && bai != 3)	//正确值, 错误值, 非法值.
//	}
//
//	/*
//		1. 创建Scanner对象, 用于接收用户录入的数据.
//		2. 提示用户录入一个大于100的三位数, 并判断. 只要用户录入的数据不合法, 就让用户一直录入.
//		   因为要求用户一直录入, 所以采用循环优化, 又因为不知道循环次数, 所以考虑使用: while 循环.
//			num > 100 && num <= 999
//		3. 走到这里, 说明用户录入的数据肯定是合法的.
//		4. 定义一个求和变量sum, 用来记录数据和.
//		5. 通过for循环, 获取100到用户录入的数字之间, 所有的整数.
//		6. 将获取到的整数, 判断, 满足条件就累加. 依次累加给变量sum.
//		7. 当for循环执行结束后, sum记录的就是我们想要的值, 打印即可.
//	*/
public class HomeWork_06 {
    public static void main(String[] args) {
        int ge = 0, shi = 0, bai = 0, qina = 0;
int sum=0;
        while (true){

            Scanner sc = new Scanner(System.in);
            System.out.println("请输入一个大于100的数字");
            int number = sc.nextInt();
         if(number>100 && number<=9999){
             for (int i = 101; i < number; i++) {
            ge = i % 10;
            shi = i / 10 % 10;
            bai = i / 100 % 10;
            if (ge != 7 && shi != 5 && bai != 3) {
                sum+=i;
                System.out.print(i + "\t");
            }
        }
             System.out.println();
             System.out.println("和为"+sum);
             break;
         }else{
             System.out.println("输入有误!");
         }

        }


    }
}
