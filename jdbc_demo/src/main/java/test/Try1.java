package test;

public class Try1 {
    public static void main(String[] args) {
        Try1 try1 = new Try1();
        int sum = try1.sum(1, 2);
        System.out.println(sum);
    }

    public int sum(int a,int b){
       return a+b;
    }
}
