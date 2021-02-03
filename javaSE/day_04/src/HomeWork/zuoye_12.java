package HomeWork;

import java.util.Scanner;

//12. 定义Demo12类, 在main中调用getArrayMax()方法,
// 用来获取数组中所有元素的最大值.
public class zuoye_12 {
    public static void main(String[] args) {
        System.out.println("请输入数组元素长度");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int[] arry=getArray(a);
        int max=getArrayMax(arry);
        System.out.println("数组中最大元素值为:"+max);
    }

    /**
     * 此方法用于获取数组中最大元素值
     * @param arry 传入的数组
     * @return 返回数组中值最大的元素
     */
    public static int getArrayMax( int[] arry) {
        for (int i = 0; i < arry.length-1; i++) {
            if(arry[i]>=arry[i+1]){
                int temp=arry[i];
                arry[i]=arry[i+1];
                arry[i+1]=temp;
            }
        }
        return arry[arry.length-1];
    }

    /**
     * 此方法用于根据指定数组长度,键盘录入获取数组
     * @param a 数组长度
     * @return 返回数组
     */
    public static int[] getArray(int a) {
        int[] arr=new int[a];
        for (int i = 0; i <a; i++) {
            System.out.println("请输入第"+(i+1)+"个元素");
            Scanner sc=new Scanner(System.in);
            int a2=sc.nextInt();
            arr[i]=a2;
        }
        return arr;
    }
}
