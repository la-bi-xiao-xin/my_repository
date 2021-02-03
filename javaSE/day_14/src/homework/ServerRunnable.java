package homework;

import java.io.*;
import java.net.Socket;

public class ServerRunnable implements Runnable {
    private Socket as;

    public ServerRunnable(Socket socket) {
        this.as = socket;
    }

    @Override
    public void run() {
        try {
            //3.创建高效字节流关联监听套接字的输入流
            BufferedInputStream bis = new BufferedInputStream(as.getInputStream());

            //4.创建高效字节输出流关联目标文件路径
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\day_14\\src\\homework\\3.txt"));

            //5.循环读取套接字中的输入流的数据到高效输出流中->到达指定文件中
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
                bos.flush();
            }
            //6.创建套接字输出流,反馈接收信息给客户端
            int len2;
            OutputStream os = as.getOutputStream();
            os.write("文件已接收".getBytes());

            //7.释放资源
            bis.close();
            as.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

    }
}
