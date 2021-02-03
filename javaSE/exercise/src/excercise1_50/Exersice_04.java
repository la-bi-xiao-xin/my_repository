package excercise1_50;

import java.util.Scanner;

//给定一个整型的数组，如果某索引有三个相邻的递增的自然数，就返回true
//例如：{...4,5,6...}或{...23,24,25}等等。

//总结:练习了类的创建,方法的创建以及调用.  Scanner 键盘录入  Static 关键字的作用
public class Exersice_04 {
    public static void main(String[] args) {
        Exersice_04 test3 = new Exersice_04();
        int[] arry = test3.getArr();  //演示的是非静态方法的调用,即使是在本类中使用也要创建对象调用
        showArr(arry);
        getResult(arry);               //静态方法在本类中可以直接使用,在别的类中可以通过类名.方法名调用
    }

    /**
     * 用于判断一个数组中是否有连续的三个递增为1的数字
     *
     * @param arr 需要判断的数组
     * @return 如果有返回true
     */
    public static void getResult(int[] arr) {
        boolean result = false;
        if (arr.length < 3) {    //判断数组长度是否大于3
            result = false;
            System.out.println("数值长度不够");
        }
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] - arr[i - 1] == 1 && arr[i + 1] - arr[i] == 1) {  //判断的依据是元素与左右相差是否为1
                result = true;
            }
        }
        System.out.println(result);
    }

    /**
     * 用于获取数组
     *
     * @param
     */
    public int[] getArr() {
        System.out.println("请输入数组长度");
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[sc.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入数组第" + (i + 1) + "个元素");
            arr[i] = sc.nextInt();
            if (i == arr.length - 1) {
                System.out.println("输入完毕!");
            }
        }
        return arr;
    }

    /**
     * 用于遍历数组
     *
     * @param arr 需要传入的数组
     */
    public static void showArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
