package homework;
/*
3. 随机点名器案例.
   提示: 高效的字符流一次读写一行.
		项目下有一个names.txt, 里边记录的是学员的名字, 格式如下(一个名字占一行)
			张三
			李四
			王五
			赵六
			...
		将上述所有数据读取出来, 存放到ArrayList<String>集合中, 然后随机从中获取一个名字即可.
	*/


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class Demo_03 {
    public static void main(String[] args) throws Exception {
        //1.创建输出流对象
        BufferedReader br = new BufferedReader(new FileReader("E:\\day_12\\src\\homework\\names.txt"));
        //2.创建ArrayList集合,用去接收读取的内容
        ArrayList<String> al = new ArrayList<>();
        //3.获取文件内容
        String getName = null;
        while ((getName = br.readLine()) != null) {
        //4.将获取的字符串添加到集合中
            al.add(getName);
        }
        System.out.println(al);
        //5.将集合乱序
        Collections.shuffle(al);
        //6.抽取集合乱序后的索引为2的元素
        System.out.println(al.get(2));
    }
}
