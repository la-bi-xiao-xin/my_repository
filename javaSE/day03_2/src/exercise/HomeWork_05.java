package exercise;
//5. 按照从大到小的顺序输出四位数中的 个位 + 百位 = 十位 + 千位(3553,2332,1166,8228,3773)的数字及个数.
//   //要求1: 每行输出5个满足条件的数，数字之间用空格(\t)分隔
//   //例如：9999 9988 9977 9966 9955
//   /*
//	思路:
//		1. 定义一个变量count, 用来记录满足条件的数字个数.
//		2. 定义一个标记变量flag, 表示几个一行.
//		3. 定义四个int类型的变量, 分别记录人: 个十百千位的值.
//			//int ge = 0, shi = 0, bai = 0, qian = 0;
//		4. 通过for循环, 获取所有的四位数. 即: 9999 -> 1000
//		5. 获取当前遍历到的数字的各个位数的值.
//		6. 判断当前数字是否是满足条件的数字.				// ge + bai == shi + qian
//		7. 满足条件则按照5个一行的形式进行输出, 且count++	//sop(i + (三元判断几个一行 ? "\r\n" : "\t"))
//		8. 当循环执行结束后, 变量count记录的就是所有满足条件的个数.
//   */
public class HomeWork_05 {
    public static void main(String[] args) {
        int count=0;
        int flag=0;
        int ge=0,shi=0,bai=0,qian=0;
        for (int i = 1000; i <9999; i++) {
            ge=i%10;
            shi=i/10%10;
            bai=i/100%10;
            qian=i/1000%10;
            if(ge+bai==shi+qian){
                System.out.print(i+"\t");
                flag++;
                count++;
                if(flag%5==0){
                    System.out.println();
            }

            }

        }
        System.out.println();
        System.out.println("符合要求的数字个数为:"+count+"个");
    }
}
