package HomeWorkExpend;
/*
6.	题目描述:
        书写一个类，类名为Itheima;
        类中有一个方法，方法名sum67;
        有一个整型数组，返回数组中的数字的总和，如果数组含有数6和7
        那么忽略不计入从6开始并延伸到有7的数字段（每6个将跟随至少一个7）。
        返回0表示没有数字。
*/

import java.util.Scanner;

public class Itheima6 {
    private int arrLength;

    public Itheima6() {
    }

    public Itheima6(int arrLength) {
        this.arrLength = arrLength;
    }

    public int getArrLength() {
        return arrLength;
    }

    public void setArrLength(int arrLength) {
        this.arrLength = arrLength;
    }

    Scanner sc = new Scanner(System.in);

    public int sum() {
        System.out.println("请输入数组长度");
        int a = sc.nextInt();
        int[] arr = new int[a];
        for (int i = 0; i < a; i++) {
            System.out.println("请输入第" + (i + 1) + "个数字");
            arr[i] = sc.nextInt();
        }

        int flag = 0;
        int flag2 = 0;
        int sum1 = 0;
        int sum2 = 0;
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]== 6) {
                flag = i;
                break;
            }
        }
        for (int j = flag + 1; j < arr.length; j++) {
            if (arr[j] == 7) {
                flag2 = j;
                break;
            }
        }
        for (int i = 0; i <flag; i++) {
            sum1+=arr[i];
        }
        if(flag2>flag){
            for (int k = flag2 + 1; k < arr.length; k++) {
                sum2 += arr[k];
            }
            sum=sum1+sum2;
        }else{
            for (int i = 0; i <arr.length ; i++) {
                sum2+=arr[i];
            }
            sum=sum2;
        }

        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
        return sum;

        }

    }



