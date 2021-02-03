package exercise;

//1. 求1-100之间的偶数和，并把求和结果打印到控制台上.
public class HomeWork_01 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i <= 100; i = i + 2) {
            sum += i;

        }
        System.out.println(sum);
    }
}
