package HomeWork;

//4. 定义int类型的数组, 存储数据: 11, 33, 22, 55, 44, 对数组元素进行反转,
// 并打印反转后的结果.
public class zuoye_04 {
    public static void main(String[] args) {
        int[] arr = {11, 33, 22, 55, 44};
        System.out.println("反转前................");
        getArr(arr);
        System.out.println();
        System.out.println("翻转后................");
        for (int i = 0; i <= arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        getArr(arr);
    }

    /**
     * 此方法用于遍历数组元素,并打印元素
     * @param arr 需要遍历的数组
     */
    public static void getArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            System.out.print(a + "\t");
        }
    }
}
