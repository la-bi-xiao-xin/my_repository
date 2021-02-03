package excercise1_50;

import java.util.Scanner;

/*1. 书写reverse方法，接收String类型的参数，要求将接收的字符串进行反转操作，将反转后的字符串返回。
例如: 传入字符串 abcdef，返回的字符串为 fedcba
2. 书写filter方法，接收String类型的参数，要求将接收的字符串中的数字过滤掉，将过滤后的字符串返回。
例如: 传入字符串 abc123def，返回的字符串为 abcdef
*/
public class Exersice_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串");
        String a = scanner.next();
        String b=reverse(a);
        System.out.println(b);
       String b2= filter(a);
        System.out.println(b2);
    }
//关键点在于将字符数组,然后遍历,以及如何将其添加到一个新的容器中返回一个字符串
    private static String filter(String a) {
        char[] chars = a.toCharArray();   //将字符串转成相应的字符数组
        StringBuilder stringBuilder2 = new StringBuilder();  //定义一个长度变的容器接收数据
        for (char b1 : chars) { //反向遍历字符数组
            if(b1<'0' || b1>'9'){
                stringBuilder2.append(b1);  //将遍历结果进行判断
            }
        }
        return stringBuilder2.toString();  //将StringBuilder 中的内容转变为字符串返回

    }

    private static String reverse(String a) {
        char[] chars = a.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {//反向遍历字符数组
            stringBuilder.append(chars[i]);//将遍历结果添加至StringBuilder中
        }
        String b = stringBuilder.toString();//将StringBuilder 中的内容转变为字符串返回
        return b;
    }
}
