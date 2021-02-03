package HomeWorkExpend;

import java.util.Scanner;



public class Itheima3 {
    public Itheima3() {
    }
   Scanner sc=new Scanner(System.in);

    /**
     * 此方法用于判断数组是否有相邻连续递增为1的3个元素
     * @param a 数组长度
     * @return 判断结果,有为true,无为false
     */
    public boolean tripleUp(int a){
        boolean result=false;
        int[] arr=new int[a];
        for (int i = 0; i <a ; i++) {
            System.out.println("请输入第"+(i+1)+"个元素");
            arr[i]=sc.nextInt();
        }
        if(arr.length<3){
            for (int i = 0; i <a; i++) {
                System.out.print(arr[i]+"\t");
            }
            result =false;
        }else if(arr.length>=3){
            for (int i = 0; i <a; i++) {
                System.out.print(arr[i]+"\t");
            }
            System.out.println();
            for (int i = 0; i <=arr.length-3; i++) {
                if(arr[i+1]-arr[i]==1 & arr[i+2]-arr[i+1]==1){
                    result=true;
                    break;
                }
            }

        }
        return result;
    }
}
