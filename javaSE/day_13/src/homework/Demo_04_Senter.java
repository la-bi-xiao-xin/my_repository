package homework;
/*
•	发送数据的步骤
        –	创建发送端的Socket对象(DatagramSocket)
        –	创建数据，并把数据打包
        –	调用DatagramSocket对象的方法发送数据
        –	关闭发送端
*/

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Demo_04_Senter {
    public static void main(String[] args) throws Exception {
        //1.创建发送端的Socket对象(DatagramSocket)
        DatagramSocket senter=new DatagramSocket();
        //2.创建数据，并把数据打包
        byte[] bytes="你好,朋友!".getBytes();
        DatagramPacket dp=new DatagramPacket(bytes,bytes.length, InetAddress.getByName("127.0.0.1"),10086);
        //3.调用DatagramSocket对象的方法发送数据
        senter.send(dp);
        //4.关闭发送端
        senter.close();
    }
}
