package com;

public class Demo_03 {
    public static void main(String[] args) {
        final int[] arr1={1,2,3,4};
        int[] arr2=arr1;

        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);

        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);

        }
        System.out.println(arr1);
        System.out.println(arr2);
    }
}
