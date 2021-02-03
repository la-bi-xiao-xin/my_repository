package homework;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/*
5. 已知有一个Map集合,里面存储的是学生的姓名和年龄，内容如下:
        {张三丰=21, 灭绝师太=38, 柳岩=28, 刘德华=40, 老鬼=36, 王二麻子=38}.
        需求: 将年龄大于24的学生姓名，存入到D:\\student.txt中
        */
public class Demo_5 {
    public static void main(String[] args) throws Exception {
        //1.创建Map集合
        Map<String, String> map = new HashMap<>();

        //2.向集合中添加键值对元素
        map.put("张三丰", "21");
        map.put("灭绝师太", "38");
        map.put("柳岩", "28");
        map.put("刘德华", "40");
        map.put("老鬼", "36");
        map.put("王二麻子", "38");
        //3.创建输出流
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\day_12\\src\\homework\\Student.txt"));
        //4.遍历集合,获取值
        for (String key : map.keySet()) {
            //5.判断值大于是否大于24
            Integer a=new Integer(map.get(key));
            if (a> 24) {
                //6,值大于24写入目标文件中
                    bos.write(key.getBytes());
                    bos.write(map.get(key).getBytes());
            }
       }
       //7.关闭输出流
        bos.close();


    }
}
