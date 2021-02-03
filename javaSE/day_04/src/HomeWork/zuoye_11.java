package HomeWork;

import java.util.Scanner;

//11. 定义Demo11类, 在main中调用printArray()方法, 用来打印数组.
public class zuoye_11 {
    public static void main(String[] args) {
        System.out.println("请输入数组长度");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int[] arr=new int[a];
        int[] arry=getArry(arr);
        System.out.println("数组元素如下:");
        printArray(arry);

    }

    /**
     * 此方法用于遍历打印数组
     * @param array 需要遍历的数组
     */
    public static void printArray( int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"\t");

        }
    }

    /**
     * 次方法用于获取数组
     * @param arr 给出空数组
     * @return 返会填充完数据的数组
     */
    public static int[] getArry( int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入数组第"+(i+1)+"个元素");
            Scanner sc=new Scanner(System.in);
            int a=sc.nextInt();
           arr[i]=a;
        }
        return arr;
    }
}
