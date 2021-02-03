package exercise;
//2. 打印所有的水仙花数, 及水仙花数的总个数.
public class HomeWork_02 {
    public static void main(String[] args) {
        int sum=0;
        int count=0;
        int ge=0,shi=0,bai=0;
        for (int i = 100; i <=999; i++) {
            ge=i%10;
            shi=i/10%10;
            bai=i/100%10;
            if(i==ge*ge*ge+shi*shi*shi+bai*bai*bai){
                System.out.println(i);
                count++;
            }
        }
        System.out.println("水仙花数个数为:"+count+"个");
    }
}
