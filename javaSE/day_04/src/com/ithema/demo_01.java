package com.ithema;

//判断两个数组指向同一个内存,其中一个数组设置为空,另一个数组是不是也会变成空
public class demo_01 {
    public static void main(String[] args) {
        int[] arr = {11, 33};
        int[] arr2;
        arr2 = arr;
        arr = null;
        System.out.println(arr);
//        System.out.println(arr[0]);
        System.out.println(arr2[0]);
    }
}
