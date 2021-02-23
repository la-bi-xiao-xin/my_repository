package JavaDemo;

public class MathDemo2 {
    public static void main(String[] args) {

        int arr2[] = {5,1,3,};
        int arr1[] = {1,4,3,5,3};
        StringBuilder stringBuilder = new StringBuilder();
        int[] ints = MathDemo2.relativeSortArray(arr1, arr2);
        for (int anInt : ints) {
            stringBuilder.append(anInt+" ");
        }
        System.out.println(stringBuilder);

    }
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        // 将 arr1 中的数记录下来
        for (int num1 : arr1) {
            count[num1]++;
        }
        // 先安排 arr2 中的数
        int i = 0;
        for (int num2 : arr2) {
            while (count[num2] > 0) {
                arr1[i++] = num2;
                count[num2]--;
            }
        }
        // 再排剩下的数
        for (int num1 = 0; num1 < count.length; num1++) {
            while (count[num1] > 0) {
                arr1[i++] = num1;
                count[num1]--;
            }
        }
        return arr1;
    }

}
