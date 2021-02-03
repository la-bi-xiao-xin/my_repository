package homework;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Demo_04_Receiver {
    public static void main(String[] args) throws Exception {
        //1.创建接收端的Socket对象(DatagramSocket)
        DatagramSocket receiver = new DatagramSocket(10086);
        while (true) {
            //2.创建用于接收数据的包
            byte[] bytes = new byte[20];
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
            //3.接收包
            receiver.receive(dp);
            //4.解析包中数据并打印
            //public String(byte[] bytes,int offset,int length)
            System.out.println("数据是：" + new String(dp.getData(), 0, dp.getLength()));
        }


    }
}
