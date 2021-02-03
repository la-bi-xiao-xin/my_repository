package HomeWork;

import java.util.Scanner;

//3. 键盘录入3个整数, 并将它们都存入到数组中, 然后获取所有元素之和, 并打印结果.
public class zuoye_03 {
    public static void main(String[] args) {
      /*  //分解版
      //获取键盘录入的三个数字
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入第一个数字");
        int number1=sc.nextInt();
        System.out.println("请输入第二个数字");
        int number2=sc.nextInt();
        System.out.println("请输入第三个数字");
        int number3=sc.nextInt();
        //定义长度为3的整型数组,并将上面获取到的数字填入数组中
        int[] arr=new int[3];
        arr[0]=number1;
        arr[1]=number2;
        arr[2]=number3;
        //求出数组所有元素之和,并打印
        int sum=arr[0]+arr[1]+arr[2];
        System.out.println("录入数字之和为:"+sum);
       */
        //整合版
        //通过步骤分解可以看出,数字录入,数字填充至数组和数组元素相加为重复步骤,
        // 可以利用循环来进行完成上述两步的操作
        Scanner sc2=new Scanner(System.in);
        int[] arr2=new int[3];
        int sum2=0;
        for (int i = 1; i <=3 ; i++) {
            System.out.println("请输入第"+i+"个数");
            int number=sc2.nextInt();
            arr2[i-1]=number;
            sum2 += arr2[i - 1];
        }
        System.out.println("录入数之和为:"+sum2);
    }
}
