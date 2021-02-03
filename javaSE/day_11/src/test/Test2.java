package test;

import java.util.HashMap;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        System.out.println("请录入一个字符串: ");
        HashMap<Character, Integer> hm = new HashMap<>();   //'a' -> 1, 'b' -> 2
        for (char key : new Scanner(System.in).nextLine().toCharArray())
            hm.put(key, !hm.containsKey(key) ? 1 : hm.get(key) + 1);

        //8. 走到这里, HashMap集合中记录的就是我们想要的结果. 按照格式将其拼接成指定的字符串即可.
        StringBuilder sb = new StringBuilder();
        //具体的拼接动作.
        for (Character key : hm.keySet())
            sb.append(key).append("(").append(hm.get(key)).append(")");
        //输出结果.
        System.out.println(sb.toString());
    }
}
