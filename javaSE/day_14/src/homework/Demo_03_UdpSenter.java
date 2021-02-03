package homework;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
    	发送数据的步骤
    	1.创建发送端的Socket对象(DatagramSocket)
    	2.创建数据，并把数据打包
    	3.调用DatagramSocket对象的方法发送数据
    	4.关闭发送端
*/
public class Demo_03_UdpSenter {
    public static void main(String[] args) throws Exception {
        //1.创建发送端的Socket对象(DatagramSocket)
        DatagramSocket ds = new DatagramSocket();
        //2.创建数据，并把数据打包
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\day_14\\src\\homework\\1.txt"));
        int len;
        byte[] bytes=new byte[1024];
        bis.read(bytes);
            DatagramPacket dt = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("127.0.0.1"), 10010);
            //3.调用DatagramSocket对象的方法发送数据
            ds.send(dt);

        //4.关闭发送端
        ds.close();
    }
}
