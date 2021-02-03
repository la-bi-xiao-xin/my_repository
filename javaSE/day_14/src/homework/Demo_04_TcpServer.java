package homework;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
    案例: 演示 TCP协议之 服务器端.

 */
public class Demo_04_TcpServer {
    public static void main(String[] args) throws Exception {
        //1. 创建服务器端的Socket对象(ServerSocket), 指定端口号.
        ServerSocket ss=new ServerSocket(10088);
        //2. 监听客户端连接. 如果有客户端申请建立连接, 服务器端在
        //审核数据成功后, 会创建一个Socket对象, 负责和此客户端的交互.
        Socket serverS=ss.accept();
        //3. 通过Socket#getInputStream(), getOutputStream()和客户端交互.
        InputStream serverInputStream = serverS.getInputStream();
        byte[] bytes=new byte[1024];
        int len=serverInputStream.read(bytes);
        System.out.println(new String(bytes, 0, len));

        byte[] bytes1="我是服务器,请求批准".getBytes();
        OutputStream serverOutputStream= serverS.getOutputStream();
        serverOutputStream.write(bytes1);
        //4. 关闭第二步的socket对象.
        serverS.close();
    }

}
