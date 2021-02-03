package HomeWork;

import java.util.Scanner;

// 6. 已知序列1, 1, 2, 3, 5, 8, 13..., 求第12个数字是多少.

public class zuoye_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入该规律下要求的第几位数");
        int a = sc.nextInt();
        //创建数组用于存储每个录入元素的值
        int[] arr = new int[a];
        //前2个序列数无规律,且个数少,采用判断语句
        // 区分出数列是元素是否>2
        if(a<=2 && a>=1){
            //如果数列元素个数<=2元素固定值为1
            for (int i = 0; i < a; i++) {
               arr[i]=1;
            }
        }else{
            //如果数列元素个数>2,元素值为
            // 第i个元素值=第i-2个元素值+第i-1个元素值,并将元素值存入数组
            arr[0]=1;
            arr[1]=1;
            for (int i = 2; i < arr.length; i++) {
                arr[i]=arr[i-2]+arr[i-1];
            }
        }
        //打印数组最后一个元素值
        System.out.println(arr[arr.length- 1]);
    }
}
