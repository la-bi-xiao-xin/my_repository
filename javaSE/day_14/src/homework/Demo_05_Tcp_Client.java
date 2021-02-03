package homework;

import java.io.*;
import java.net.Socket;

public class Demo_05_Tcp_Client {
    public static void main(String[] args) throws IOException {
        //1.创建客户端Socket对象,指定IP地址和端口号
        Socket scoket = new Socket("127.0.0.1", 19951);
        //2.创建输入流关联源文件路径
        BufferedReader br = new BufferedReader(new FileReader("E:\\day_14\\src\\homework\\1.txt"));

        //3.创建输出流,关联Scoket的OutputStream输出流
        //BufferedWriter对象创建格式为   BufferedWriter bw=new BufferedWriter(Writer a)
        //而new OutputStreamWriter(scoket.getOutputStream())转换流,可以将字节流转换为字符流即Writer 字符流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(scoket.getOutputStream()));

        //4.循环读取数据到Socket OutputStream流中
        String s = null;
        while ((s = br.readLine()) != null) {
            bw.write(s);
            bw.newLine();
            bw.flush();
        }
        //5.标志文件读取完毕
        scoket.shutdownOutput();

        //6.创建Socket的InputStream流对象,接收服务器反馈
        InputStream is = scoket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);

        //7.打印反馈信息
        System.out.println(new String(bytes, 0, len));
        br.close();
        scoket.close();
    }
}
