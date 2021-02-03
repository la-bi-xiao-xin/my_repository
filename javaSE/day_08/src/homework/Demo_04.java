package homework;

import java.util.Scanner;

/*
需求4:
        键盘录入一个字符串, 统计该字符串中大写字母字符, 小写字母字符,
        数字字符出现的次数.
        注意: 不考虑其他字符, 例如@, !, \, /等
        */
public class Demo_04 {
    public static void main(String[] args) {
        //1.创建Scanner对象接收录入对象
      Scanner sc=new Scanner(System.in);
        System.out.println("请输入字符串");
        String s=sc.nextLine();
        //2.判断录入对象中的大小写及数字字符的个数,
        // 利用到String类的charAt()和length()方法
        int smallCount=0;
        int bigCount=0;
        int numberCount=0;
        if(s!=null)
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)>='a'  && s.charAt(i)<='z'){
                smallCount++;
            }else if(s.charAt(i)>='A'  && s.charAt(i)<='B'){
                bigCount++;
            }else if(s.charAt(i)>='0'  && s.charAt(i)<='9'){
                numberCount++;
            }

        }
        System.out.println("小写字母个数为:"+smallCount);
        System.out.println("大写字母个数为:"+bigCount);
        System.out.println("数字个数为:"+numberCount);
        }
    }

