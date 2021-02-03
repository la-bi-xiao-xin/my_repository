package homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo_06_Tcp_Server {
    public static void main(String[] args) throws IOException {
        //1.创建服务器端套接字ServerSocket指定端口号
        ServerSocket ss = new ServerSocket(23345);

        while (true){
            //2.创建监听套接字对象
            Socket as = ss.accept();
            Thread clients = new Thread(new ServerRunnable(as));
            clients.start();
        }
    }
}
