package HomeWork;

import java.util.Scanner;

//5. 在编程竞赛中, 有6个评委为参赛的选手打分, 分数在0~100之间.
// 假设小明参加比赛后, 评委对其进行打分, 去掉最高分和最低分求小明的平均分是多少,
// 总分是多少
// 并将结果打印到控制台上.
public class zuoye_05 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr=new int[6];
        int[] arry=getScore(sc, arr);
        int max=getMax(arr);
        System.out.println("最高分为"+max);
        int min=getMin(arr);
        System.out.println("最低分为"+min);
        int sum=getSum(arry);
        System.out.println("总分为"+sum);
        int avg=(sum-max-min)/4;
        System.out.println("平均分为"+avg);
    }

    /**
     * 次方法用于求数组元素之和
     * @param arr 需要遍历的数组
     * @return 返回数组元素之和
     */
    public static int getSum(int[] arr) {
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        return sum;
    }

    /**
     * 此方法用于获取数组元素中最小值
     * @param arr 需要传入的数组
     * @return 返回数组元素最小值
     */
    public static int getMin(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]<arr[i+1]){
                int temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
        return arr[arr.length-1];
    }

    /**
     * 此方法用于求出数组中最大值
     * @param arr 需要传入的数组
     * @return 返回最大值
     */
    public static int getMax(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]>arr[i+1]){
                int temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
        return arr[arr.length-1];
    }

    /**
     * 此方法用于录入6位评委给的评分并将分数填入数组
     * @param sc 接受录入的分数值
     * @param arr 用于存储分数的数组
     */
    public static int[] getScore(Scanner sc, int[] arr) {
        for (int i = 0; i <6; i++) {
            System.out.println("请第"+(i+1)+"位评委打分");
            int score=sc.nextInt();
            arr[i]=score;
        }
        return arr;
    }

}
