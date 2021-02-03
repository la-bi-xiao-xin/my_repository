package HomeWork;
/*
3. 某小伙想定一份外卖，商家的优惠方式如下：鱼香肉丝单点24元(fish)，
        油炸花生米单点8元(peanut)，米饭单点3元(rice)。
        订单满30元8折优惠, 鱼香肉丝优惠价16元，
        但是优惠价和折扣不能同时使用。那么这个小伙要点这三样东西，
        最少要花多少钱？
*/

public class zuoye_03 {
    public static void main(String[] args) {
        int fish=24;
        int peanut=8;
        int rice=3;
        if(fish+peanut+rice>30){
            double a=(fish+peanut+rice)*0.8;
            double b=16+peanut+rice;
            double sum1=a>b?a:b;
            System.out.println("最少要花"+sum1+"元");
        }else {
            int sum2=fish+peanut+rice;
            System.out.println("最少要花"+sum2+"元");
        }




    }
}
