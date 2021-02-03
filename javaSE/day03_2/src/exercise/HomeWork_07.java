package exercise;

//7.求1到100 之间的质数,每3个一行在控制台上打印出来
public class HomeWork_07 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 2; i <= 100; i++) {
            boolean flag = true;
            for (int j = 2; j <= i/2; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag = true) {
                count++;
                System.out.print(i + "\t");
                if (count % 3 == 0) {
                    System.out.println();
                }
            }
        }
    }
}
