package homework;

import java.util.Arrays;

/*
1. 已知数组int[] arr = {25, 69, 80, 57, 13}, 请编写代码对齐进行升序排序.
        即: 排序后结果为: arr = {13, 25, 57, 69, 80};
//两种思路实现.
*/
public class Demo_01 {
    public static void main(String[] args) {
        //1.创建数组对象
        int[] arr = {25, 69, 80, 57, 13};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        /*//思路一:冒泡排序法
        for (int i = 0; i < arr.length - 1; i++) {
        //分析出循环轮数,不做优化的情况下完全可以有几个元素就循环几轮,但是勒,
        最后一个元素因为前面的元素都已经确定了位置,剩下的一个位置自然就是最后一个元素的位置,
        因此为提高代码的运行效率就少比较一轮,即5 个元素比较4 轮.
            for (int j = 0; j < arr.length - i - 1; j++) {
            //每轮比较的次数按照不优化的思路来比,就是该轮有n个元素需要比较就比较n-1次,确认最大值.
           // 但是每比完一轮就可以确定敲定一个位置,少比一次,也就是在第几轮就少比几次
                if (arr[j] >= arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
        */
        //思路二:使用Arraysl类中的sort()方法
        Arrays.sort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
        //如何保留原来数组?做完升序操作后,后面如果还想用arr原来的数组怎么办?
        //在最开始的时候// int[] arr2= {25, 69, 80, 57, 13};,但不能int[] arr2=arr;
    }
}
