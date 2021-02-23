package mathpractice;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("请输入计算指令,例如'AB'");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println("请输入x的值");
        int x = scanner.nextInt();
        System.out.println("请输入y的值");
        int y = scanner.nextInt();

        char[] orders = line.toCharArray();
        for (int i = 0; i <orders.length ; i++) {
            if(orders[i]=='A'){
                x=exexuteA(x,y);
            } else if(orders[i]=='B'){
                y=exexuteB(x,y);
            }

        }
        System.out.println(x+y);
        
        TimeUnit.SECONDS.sleep(1000);


    }
    public static int exexuteA(int x,int y){
        return 2 * x + y;
    }
    public static int exexuteB(int x,int y){
        return 2 * y + x;
    }
}
