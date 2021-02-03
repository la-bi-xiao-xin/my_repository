package homework;
/*•	案例需求
 	客户端：数据来自于文本文件，接收服务器反馈
 	服务器：接收到的数据写入文本文件，给出反馈，代码用线程进行封装，为每一个客户端开启一个线程
*/

import java.io.*;
import java.net.Socket;

public class Demo_06_Tcp_Client {
    public static void main(String[] args) throws IOException {
        //1.创建客户端Socket对象,指定关联IP地址和端口号
        Socket s = new Socket("127.0.0.1", 23345);

        //2.创建高效字节输入流,关联源文件路径
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\day_14\\src\\homework\\1.txt"));

        //3.创建高效字节输出流,关联套接字的InputSttream字节输入流
        BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());

        //4.循环读取文件数据至套接字的输入流中
        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, bytes.length);
            bos.flush();
        }
        //5.标记套接字输出流关闭
        s.shutdownOutput();
        ;

        //6.创建套接字输入流接收服务器反馈
        byte[] bytes1 = new byte[1024];
        int len2;
        InputStream is = s.getInputStream();
        is.read(bytes1);
        //7.打印反馈客户端反馈信息
        System.out.println(new String(bytes1, 0, bytes1.length));

        //8.释放资源
        bis.close();
        s.close();


    }
}
