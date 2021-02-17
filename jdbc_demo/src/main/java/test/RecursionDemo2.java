package test;

public class RecursionDemo2 {

    //用递归求解
    public static int fib(int n) {

        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        return fib(n - 1) + fib(n - 2);
    }

    //用循环求解
    public static int fib2(int n) {
        int a = 0, b = 1, c = 1;
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        for (int i = 0; i < n - 1; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    //用数组求解
    public static int fib3(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];

    }


    public static void main(String[] args) {
        System.out.println(fib(5));
    }
}