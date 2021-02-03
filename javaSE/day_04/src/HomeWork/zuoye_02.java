package HomeWork;
//2. 已知数组int[] arr = {5, 15, 2000, 10000, 100, 4000};, 求数组所有元素中的最小值.
public class zuoye_02 {
    public static void main(String[] args) {
        //int[] arr=new int[]{5,15,2000,10000,100,4000};
        int[] arr={5, 15, 2000, 10000, 100, 4000};
        //注意:for循环判断条件设置,防止产生索引越界异常
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]<arr[i+1]){
                int temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }else{
                continue;
            }

        }
        System.out.println(arr[arr.length - 1]);
    }
}
