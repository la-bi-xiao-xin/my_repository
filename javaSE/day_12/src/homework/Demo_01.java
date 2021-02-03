package homework;

import java.io.*;

/*
1. 复制图片, 或者视频.		//要求, 用4种方法实现.
        1. 普通的字节流一次读写一个字节.
        2. 普通的字节流一次读写一个字节数组.			//必须掌握.
        3. 高效的字节流一次读写一个字节.				//必须掌握.
        4. 高效的字节流一次读写一个字节数组.
        */
public class Demo_01 {
    public static void main(String[] args) throws Exception {
        //一. 普通的字节流一次读写一个字节.
        // method_01();
        //二. 普通的字节流一次读写一个字节数组.			//必须掌握.
        // method_02();
        //三. 高效的字节流一次读写一个字节.				//必须掌握.
        //method_03();
        //四. 高效的字节流一次读写一个字节数组.
        mothed_04();
    }

    public static void mothed_04() throws IOException {
        // 1. 创建输入流对象, 关联数据源文件.
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\day_12\\src\\homework\\01. 集合体系图(原图).png"));
        //2. 创建输出流对象, 关联目的地文件.
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\day_12\\src\\homework\\01. 集合体系图(拷贝4).png"));
        //3. 定义变量, 用来记录读取到的内容.
        int len;
        byte[] bytes = new byte[8192];
        //4. 循环读取, 并将读取到的内容赋值给变量, 只要条件满足就一直读.
        while ((len = bis.read(bytes)) != -1)
            //5. 将读取到的数据写入到目的地文件中.
            bos.write(bytes, 0, 8192);
        // 6. 释放资源.
        bis.close();
        bos.close();
    }

    public static void method_03() throws IOException {
        // 1. 创建输入流对象, 关联数据源文件.
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\day_12\\src\\homework\\01. 集合体系图(原图).png"));
        //2. 创建输出流对象, 关联目的地文件.
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\day_12\\src\\homework\\01. 集合体系图(拷贝3).png"));
        //3. 定义变量, 用来记录读取到的内容.
        int len;
        //4. 循环读取, 并将读取到的内容赋值给变量, 只要条件满足就一直读.
        while ((len = bis.read()) != -1)
            //5. 将读取到的数据写入到目的地文件中.
            bos.write(len);
        // 6. 释放资源.
        bis.close();
        bos.close();
    }

    public static void method_02() throws IOException {
        // 1. 创建输入流对象, 关联数据源文件.
        FileInputStream fis = new FileInputStream("E:\\day_12\\src\\homework\\01. 集合体系图(原图).png");
        //2. 创建输出流对象, 关联目的地文件.
        FileOutputStream fos = new FileOutputStream("E:\\day_12\\src\\homework\\01. 集合体系图(拷贝2).png");
        //3. 定义变量, 用来记录读取到的内容.
        int len;
        byte[] bytes = new byte[8192];
        //4. 循环读取, 并将读取到的内容赋值给变量, 只要条件满足就一直读.
        while ((len = fis.read(bytes)) != -1)
            //5. 将读取到的数据写入到目的地文件中.
            fos.write(bytes, 0, 8192);
        // 6. 释放资源.
        fis.close();
        fos.close();
    }

    public static void method_01() throws IOException {
        // 1. 创建输入流对象, 关联数据源文件.
        FileInputStream fis = new FileInputStream("E:\\day_12\\src\\homework\\01. 集合体系图(原图).png");
        //2. 创建输出流对象, 关联目的地文件.
        FileOutputStream fos = new FileOutputStream("E:\\day_12\\src\\homework\\01. 集合体系图(拷贝).png");
        //3. 定义变量, 用来记录读取到的内容.
        int len;
        //4. 循环读取, 并将读取到的内容赋值给变量, 只要条件满足就一直读.
        while ((len = fis.read()) != -1)
            //5. 将读取到的数据写入到目的地文件中.
            fos.write(len);
        // 6. 释放资源.
        fis.close();
        fos.close();
    }
}
