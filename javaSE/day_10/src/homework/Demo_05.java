package homework;

import java.util.LinkedList;

/*
第五题: 通过代码, 完成如下需求:
        1. 定义LinkedList集合, 存储字符串数据, 例如: "hello", "world", "java".
        2. 测试LinkedList集合中常用的方法.
    addFirst(), addLast(), removeFirst(), removeLast(), getFirst(), getLast()

        */
public class Demo_05 {
    public static void main(String[] args) {
        //1.创建LinkedList集合对象
        LinkedList<String> ll = new LinkedList<>();

        //2.在集合中存储"hello", "world", "java"元素
        ll.add("hello");
        ll.add("world");
        ll.add("java");
        System.out.println(ll);
        System.out.println("***********************************");

        //3.测试LinkedList集合中常用的方法.
        //3.1测试LinkedList集合中的addFirst()方法
        ll.addFirst("你好");
        System.out.println(ll);
        System.out.println("***********************************");

        //3.2测试LinkedList集合中的 addLast()方法
        ll.addLast("世界");
        System.out.println(ll);
        System.out.println("***********************************");

        //3.3测试LinkedList集合中的 removeFirst()方法
        ll.removeFirst();
        System.out.println(ll);
        System.out.println("***********************************");

        //3.4测试LinkedList集合中的 removeLirst()方法
        ll.removeLast();
        System.out.println(ll);
        System.out.println("***********************************");

        //3.5测试LinkedList集合中的getFirst()方法
        System.out.println(ll.getFirst());
        System.out.println("***********************************");

        //3.6测试LinkedList集合中的 getLast()方法
        System.out.println(ll.getLast());
    }
}
