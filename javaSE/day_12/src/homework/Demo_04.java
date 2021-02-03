package homework;
/*
4. 已知项目下有个a.txt文本文件，里边有两行数据，如下：
        a,c,d,e,g,h
        a,g,b,o,q,r
        需求：
        创建输入流，读取这两行数据，每行数据都可以看做是一个ArrayList<String>集合，
        而每行的字母就是该集合中的元素。
        对两个集合中的元素合并后去重，然后将去重后的结果写入到项目下的b.txt文本文件中, 格式如下:
        //可以不是如下的顺序, 但是要一个字符占一行.
        a
        b
        c
        d
        e
        ...
        */

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Demo_04 {
    public static void main(String[] args) throws Exception {
        //1.创建输入出流对象
        BufferedReader br = new BufferedReader(new FileReader("E:\\day_12\\src\\homework\\a.txt"));

        //2.创建ArrayList集合,用去接收读取的内容
        ArrayList<String> al = new ArrayList<>();
        ArrayList<String> al2 = new ArrayList<>();
        String[] arr = new String[2];
        //HashMap<Integer,ArrayList<String>> hm=new HashMap<>();
        //3.获取文件内容
        String getString = null;
        int i = 0;
        while ((getString = br.readLine()) != null) {
            //4.将获取的字符串添加到数组中
            arr[i] = getString;
            i++;
        }

        for (String s : arr[0].split(",")) {
            al.add(s);
        }
        for (String s2 : arr[1].split(",")) {
            al2.add(s2);

        }
        System.out.println(al);
        System.out.println(al2);
        //5.c创建HashSet集合接收ArrayList集合中的元素
        HashSet<String> hs = new HashSet<>();
        for (String s1 : al) {
            hs.add(s1);
        }
        for (String s2 : al2) {
            hs.add(s2);

        }
        System.out.println(hs);
        //6.创建输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\day_12\\src\\homework\\b.txt"));
        //7.循环写入
        for (String h : hs) {
            bw.write(h);
            bw.newLine();

        }
        //7.关闭输入输出流
        br.close();
        bw.close();
    }


}

