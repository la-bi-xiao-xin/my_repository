package homework;

import java.util.ArrayList;
import java.util.ListIterator;

/*
第六题: 通过代码, 完成如下需求:
        1. 定义ArrayList集合，存入多个字符串,
        例如: "ab1", "123ad", "def", "bca", "def", "def", "dadfadf"  "dddaaa"  "你好啊"  "我来啦"  "别跑啊"
        2. 遍历集合, 删除长度大于5的字符串, 打印删除后的集合对象
        3. 基于上一步, 删除集合中元素包含0-9数字的字符串
        (只要字符串中包含0-9中的任意一个数字就需要删除此整个字符串), 打印删除后的集合对象.
        4. 基于上一步, 删除集合中所有的"def"字符串, 打印删除后的集合对象.
        */
public class Demo_06 {
    public static void main(String[] args) {
        //1.创建ArrayList集合
        ArrayList<String> al = new ArrayList<>();
        //2.添加集合元素
        al.add("ab1");
        al.add("123ad");
        al.add("def");
        al.add("bca");
        al.add("def");
        al.add("def");
        al.add("dadfadf");
        al.add("dddaaa");
        al.add("你好啊");
        al.add("我来啦");
        al.add("别跑啊");
        System.out.println(al);
        System.out.println("*********************************************************");
        //3.列表迭代器遍历集合
        ListIterator<String> li = al.listIterator();
        //4.列表迭代器遍历集合, 删除长度大于5的字符串
        while (li.hasNext()) {
            if (li.next().length() > 5)
                li.remove();
        }
        System.out.println(al);
        System.out.println("*********************************************************");

        //4.删除集合中元素包含0-9数字的字符串
        //(只要字符串中包含0-9中的任意一个数字就需要删除此整个字符串), 打印删除后的集合对象.
        while (li.hasPrevious()) {
            if (result(li.previous()))
                li.remove();
        }
        System.out.println(al);
        System.out.println("*********************************************************");

        //5.删除集合中所有的"def"字符串, 打印删除后的集合对象.
        while (li.hasNext()) {
            if ( "def".equals(li.next()))
                li.remove();
        }
        System.out.println(al);
    }

    public static boolean result(String s) {
        boolean result = false;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= '0' && c[i] <= '9')
                result = true;
        }
        return result;
    }
}
