package homework;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
•	接收数据的步骤
–	创建接收端的Socket对象(DatagramSocket)
–	创建一个数据包，用于接收数据
–	调用DatagramSocket对象的方法接收数据
–	解析数据包，并把数据在控制台显示
–	关闭接收端
*/
public class Demo_03_UdpRecever {
    public static void main(String[] args) throws Exception {
        //1.创建接收端的Socket对象(DatagramSocket)
        DatagramSocket socket = new DatagramSocket(10010);
        // 2.创建一个数据包，用于接收数据
        byte[] bytes=new byte[1024];
        DatagramPacket dp=new DatagramPacket(bytes,bytes.length);
	   // 3.调用DatagramSocket对象的方法接收数据
        socket.receive(dp);
	   // 4.解析数据包，并把数据在控制台显示
        System.out.println(new String(dp.getData(), 0, dp.getLength()));
        //5.关闭接收端
        socket.close();
    }
}
