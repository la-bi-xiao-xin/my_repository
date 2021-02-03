package homework;

import java.io.*;

/*
2. 复制文本文件.			//要求, 用11种方式实现.
	1. 普通的字节流一次读写一个字节.
	2. 普通的字节流一次读写一个字节数组.			//必须掌握.

	3. 高效的字节流一次读写一个字节.				//必须掌握.
	4. 高效的字节流一次读写一个字节数组.

	5. 转换流一次读取一个字符.
	6. 转换流一次读取一个字符数组.

	7. 普通的字符流一次读写一个字符.
	8. 普通的字符流一次读写一个字符数组.

	9. 高效的字符流一次读写一个字符.
	10. 高效的字符流一次读写一个字符数组.
	11. 高效的字符流一次读写一行. 					//必须, 必须, 必须掌握.
 */
public class Demo_02 {
    public static void main(String[] args) throws Exception {
        //一. 普通的字节流一次读写一个字节.
        // mothed_01();

        //二. 普通的字节流一次读写一个字节数组.			//必须掌握.
        // mothed_02();

        //三.3. 高效的字节流一次读写一个字节.				//必须掌握.
        //mothed_03();

        //四.高效的字节流一次读写一个字节数组.
        //mothed_04();

        //五.5. 转换流一次读取一个字符.     没出结果!!!!!!!!!!!!!!
        //motrhed_05();

        //六.6. 转换流一次读取一个字符数组. 没出结果!!!!!!!!!!!!!!
        // mothed_06();

        //七.普通的字符流一次读写一个字符.
        //mothed_7();

        //八.普通的字符流一次读写一个字符数组.
        //mothed_8();

        //九.9. 高效的字符流一次读写一个字符.
        //mothed_9();

        //十.高效的字符流一次读写一个字符数组.
        //mothed_10();

        //十一. 高效的字符流一次读写一行.
        mothed_11();


    }

    public static void mothed_11() throws IOException {
        //1. 创建输入流对象, 关联数据源文件.
        BufferedReader br = new BufferedReader(new FileReader("E:\\day_12\\src\\homework\\1.txt"));
        //2. 创建输出流对象, 关联目的地文件.
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\day_12\\src\\homework\\1(拷贝6).txt"));
        //3. 定义变量, 用来记录读取到的内容.
        String s = null;
        //4. 循环读取, 并将读取到的内容赋值给变量, 只要条件满足就一直读.
        while ((s = br.readLine()) != null) {
            //5. 将读取到的数据写入到目的地文件中.
            bw.write(s);
            bw.newLine();
        }
        //6. 释放资源.
        br.close();
        bw.close();
    }

    public static void mothed_10() throws IOException {
        //1. 创建输入流对象, 关联数据源文件.
        BufferedReader br = new BufferedReader(new FileReader("E:\\day_12\\src\\homework\\1.txt"));
        //2. 创建输出流对象, 关联目的地文件.
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\day_12\\src\\homework\\1(拷贝5).txt"));
        //3. 定义变量, 用来记录读取到的内容.
        int len;
        char[] chars = new char[5];
        //4. 循环读取, 并将读取到的内容赋值给变量, 只要条件满足就一直读.
        while ((len = br.read(chars)) != -1)
            //5. 将读取到的数据写入到目的地文件中.
            bw.write(chars, 0, 5);
        //6. 释放资源.
        br.close();
        bw.close();
    }

    public static void mothed_9() throws IOException {
        //1. 创建输入流对象, 关联数据源文件.
        BufferedReader br = new BufferedReader(new FileReader("E:\\day_12\\src\\homework\\1.txt"));
        //2. 创建输出流对象, 关联目的地文件.
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\day_12\\src\\homework\\1(拷贝4).txt"));
        //3. 定义变量, 用来记录读取到的内容.
        int len;
        //4. 循环读取, 并将读取到的内容赋值给变量, 只要条件满足就一直读.
        while ((len = br.read()) != -1)
            //5. 将读取到的数据写入到目的地文件中.
            bw.write(len);
        //6. 释放资源.
        br.close();
        bw.close();
    }

    public static void mothed_8() throws IOException {
        //1. 创建输入流对象, 关联数据源文件.
        FileReader fr = new FileReader("E:\\day_12\\src\\homework\\1.txt");
        //2. 创建输出流对象, 关联目的地文件.
        FileWriter fw = new FileWriter("E:\\day_12\\src\\homework\\1(拷贝3).txt");
        //3. 定义变量, 用来记录读取到的内容.
        int a;
        char[] chars = new char[5];
        //4. 循环读取, 并将读取到的内容赋值给变量, 只要条件满足就一直读.
        while ((a = fr.read(chars)) != -1)
            //5. 将读取到的数据写入到目的地文件中.
            fw.write(chars, 0, 5);
        //6. 释放资源.
        fr.close();
        fw.close();
    }

    public static void mothed_7() throws IOException {
        //1. 创建输入流对象, 关联数据源文件.
        FileReader fr = new FileReader("E:\\day_12\\src\\homework\\1.txt");
        //2. 创建输出流对象, 关联目的地文件.
        FileWriter fw = new FileWriter("E:\\day_12\\src\\homework\\1(拷贝3).txt");
        //3. 定义变量, 用来记录读取到的内容.
        int a;
        //4. 循环读取, 并将读取到的内容赋值给变量, 只要条件满足就一直读.
        while ((a = fr.read()) != -1)
            fw.write(a);
        //5. 将读取到的数据写入到目的地文件中.
        fr.close();
        fw.close();
        //6. 释放资源.
    }

    public static void mothed_06() throws IOException {
        //1. 创建输入流对象, 关联数据源文件.
        InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\day_12\\src\\homework\\1.txt"), "utf-8");
        //2. 创建输出流对象, 关联目的地文件.
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\day_12\\src\\homework\\1(拷贝2).txt"), "utf-8");
        //3. 定义变量, 用来记录读取到的内容.
        int len;
        char[] chars = new char[5];
        //4. 循环读取, 并将读取到的内容赋值给变量, 只要条件满足就一直读.
        while ((len = isr.read(chars)) != -1) {
            //5. 将读取到的数据写入到目的地文件中.
            osw.write(chars, 0, 5);
        }

        //6. 释放资源.
        isr.close();
        osw.close();
    }

    public static void motrhed_05() throws IOException {
        //1. 创建输入流对象, 关联数据源文件.
        InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\day_12\\src\\homework\\1.txt"), "utf-8");
        //2. 创建输出流对象, 关联目的地文件.
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\day_12\\src\\homework\\1(拷贝1).txt"), "utf-8");
        //3. 定义变量, 用来记录读取到的内容.
        int len;
        //4. 循环读取, 并将读取到的内容赋值给变量, 只要条件满足就一直读.
        while ((len = isr.read()) != -1) {
            //5. 将读取到的数据写入到目的地文件中.
            osw.write(len);
        }
        //6. 释放资源.
        isr.close();
        osw.close();
    }

    public static void mothed_04() throws IOException {
        //1. 创建输入流对象, 关联数据源文件.
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\day_12\\src\\homework\\02. IO流解释(原图).png"));
        //2. 创建输出流对象, 关联目的地文件.
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\day_12\\src\\homework\\02. IO流解释(拷贝4).png"));
        //3. 定义变量, 用来记录读取到的内容.
        int len;
        byte[] bytes = new byte[2048];
        //4. 循环读取, 并将读取到的内容赋值给变量, 只要条件满足就一直读.
        while ((len = bis.read(bytes)) != -1)
            //5. 将读取到的数据写入到目的地文件中.
            //bos.write(bytes,0,1024);    //此处读取长度改成不是2048的值,会写入失败
            bos.write(bytes, 0, 2048);
        //6. 释放资源.
        bis.close();
        bos.close();
    }

    public static void mothed_03() throws IOException {
        //1. 创建输入流对象, 关联数据源文件.
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\day_12\\src\\homework\\02. IO流解释(原图).png"));
        //2. 创建输出流对象, 关联目的地文件.
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\day_12\\src\\homework\\02. IO流解释(拷贝3).png"));
        //3. 定义变量, 用来记录读取到的内容.
        int len;
        //4. 循环读取, 并将读取到的内容赋值给变量, 只要条件满足就一直读.
        while ((len = bis.read()) != -1)
            //5. 将读取到的数据写入到目的地文件中.
            bos.write(len);
        //6. 释放资源.
        bis.close();
        bos.close();
    }

    public static void mothed_02() throws IOException {
        // 1. 创建输入流对象, 关联数据源文件.
        FileInputStream fis = new FileInputStream("E:\\day_12\\src\\homework\\02. IO流解释(原图).png");
        //2. 创建输出流对象, 关联目的地文件.
        FileOutputStream fos = new FileOutputStream("E:\\day_12\\src\\homework\\02. IO流解释(拷贝2).png");
        //3. 定义变量, 用来记录读取到的内容.
        int len;
        byte[] bytes = new byte[1024];
        //4. 循环读取, 并将读取到的内容赋值给变量, 只要条件满足就一直读.
        while ((len = fis.read(bytes)) != -1)
            //5. 将读取到的数据写入到目的地文件中.
            fos.write(bytes, 0, 1024);
        // 6. 释放资源.
        fis.close();
        fos.close();
    }

    public static void mothed_01() throws IOException {
        // 1. 创建输入流对象, 关联数据源文件.
        FileInputStream fis = new FileInputStream("E:\\day_12\\src\\homework\\02. IO流解释(原图).png");
        //2. 创建输出流对象, 关联目的地文件.
        FileOutputStream fos = new FileOutputStream("E:\\day_12\\src\\homework\\02. IO流解释(拷贝1).png");
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
