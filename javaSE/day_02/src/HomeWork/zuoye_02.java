package HomeWork;
/*
2. 已知: 红茶妹妹有21元钱，她攒了几天钱之后自己的钱比原来的两倍还多三块。
        绿茶妹妹有24元钱，她攒了几天钱之后自己的钱正好是原来的两倍。
        判断红茶妹妹和绿茶妹妹的钱是否一致, 并打印结果.
*/
/*
 提示:
     1. 定义红茶妹妹原来的钱为整数变量
     2. 定义绿茶妹妹原来的钱为整数变量
     3. 使用赋值运算符和算术运算符计算其现有的钱
     4. 使用比较运算符对数值做出比较
*/
public class zuoye_02 {
    public static void main(String[] args) {
        int a=21;
        int b=24;
        boolean flog=(a*2+3)==(b*2)?true:false;
        if(flog){
            System.out.println("红茶妹妹和绿茶妹妹的钱一样多");

        }else {
            System.out.println("红茶妹妹和绿茶妹妹的钱不相等");

        }
    }
}
