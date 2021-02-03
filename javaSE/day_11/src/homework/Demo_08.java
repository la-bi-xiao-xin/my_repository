package homework;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
第八题: 通过代码, 完成如下需求:
        1. 键盘录入一个字符串，要求统计字符串中每个字符串出现的次数。
        2. 举例：键盘录入“aababcabcdabcde”
        在控制台输出：“a(5)b(4)c(3)d(2)e(1)”
        */
public class Demo_08 {
    public static void main(String[] args) {
        //1.创建Scanner对象,接收键盘录入对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请录入要求统计的字符串");

        //2.获取键盘录入字符串对象
        String s = sc.nextLine();

        //3.将字符串对象转为字符数组
        char[] charArray = s.toCharArray();

        //4.创建HashMap列表用于记录字符统计结果
        HashMap<Character, Integer> hm = new HashMap<>();

        //5.遍历字符数组,并将字符统计结果填入集合
        for (char c : charArray) {
            if (!hm.containsKey(c)) { //判断键是否存在
                hm.put(c, 1);           //不存在就是第一次出现,值设置为1
            } else
                hm.put(c, hm.get(c) + 1); //存在就改变其对应的值,在原来的值上加一

        }
        System.out.println(hm);
        System.out.println("*******************");

        //6.创建StringBuilder对象拼接
        StringBuilder builder = new StringBuilder();
        /*
        Set<Character> ks = hm.keySet();//获取键集合
        for (int i = 0; i <ks.size() ; i++) {//循环键集合
            Character key=ks集合里面的第i个元素;//Set列表无法用索引获取元素,所以用中国表达(功能是获取键集合里的键元素)
             builder.append(key + "(" + hm.get(key) + ")");
        }
        */
        //上述是用不同for演示遍历步骤,用于加强对增强for的理解
        for (Character key : hm.keySet()) {
            builder.append(key + "(" + hm.get(key) + ")");
        }
        //7.打印结果
        System.out.println(builder);

    }
}
