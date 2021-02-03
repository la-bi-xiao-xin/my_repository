package homework;

import java.util.Scanner;

/*
需求5:	//两种思路: 思路1: String, 思路二: StringBuilder
        1.定义方法arrayToString(), 把int数组的元素按照指定的格式拼接成一个字符串,
         并返回.
        2.在main方法中, 调用上述的方法.
        3.例如: 数组为int[] arr = {1, 2, 3}, 则拼接后, 结果为: [1, 2, 3]
        */
public class Demo_05 {
    public static void main(String[] args) {

        int[] arry = getArry();
        printArry(arry);
        // 思路1: String
        //利用String类的charAt()和length()方法
        //arrayToString(arry);
        //思路二: StringBuilder
        arryToStringByStringBuilder(arry);


    }

    public static void arryToStringByStringBuilder(int[] arry) {
        StringBuilder sb=new StringBuilder("[");
        for (int i = 0; i <arry.length ; i++) {
            if(i<=arry.length-2){
                sb.append(arry[i]).append(",");
            }else
                sb.append(arry[i]).append("]");
        }
        //System.out.println(sb.toString());
        System.out.println(sb);
    }

    public static void arrayToString(int[] arry) {
        String s1 = "[";
        System.out.print(s1);
        for (int i = 0; i < arry.length; i++) {
            if (i <= arry.length - 2) {
                System.out.print(arry[i] + ", ");
            } else
                System.out.print(arry[i] + "]");

        }
    }

    public static void printArry(int[] arry) {
        for (int i = 0; i < arry.length; i++) {
            System.out.print(arry[i] + "\t");


        }
        System.out.println();
    }

    public static int[] getArry() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组长度");
        int a = sc.nextInt();
        // int[] arr=int[a]; 报错原因没有写new
        int[] arr = new int[a];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("输入第" + (i + 1) + "个元素");
            arr[i] = sc.nextInt();

        }
        return arr;
    }
}
