package homework;

import java.util.HashMap;
import java.util.Map;

/*
第4题: 通过代码, 完成如下需求:
    1. 统计每个单词出现的次数
    2. 有如下字符串
    "If you want to change your fate I think you must come to
     the dark horse to learn java"(用空格间隔)
    3. 打印格式：
    to=3
    think=1
    you=2
    //........

    //提示; String#split(" ");			//按照指定的字符串切割.
    String{] arr = {"If", "you", "want"};
    HashMap<String, Integer>
*/
public class Extend_04 {
    public static void main(String[] args) {
        String s = "If you want to change your fate I think you must come to the dark horse to learn java";
        //1.获取分割后的字符串数组
        String[] arrayStr = s.split(" ");

        //2.定义HashMap集合,存储字符串及字符串出现的次数
        HashMap<String, Integer> hm = new HashMap<>();
        for (String s1 : arrayStr) {
            if (!hm.containsKey(s1))
                hm.put(s1, 1);
            else
                hm.put(s1, hm.get(s1) + 1);
        }

        //3.增强for 通过键值对遍历集合,打印结果
        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());

        }
    }
}
