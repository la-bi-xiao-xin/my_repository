package homework;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo_01 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address=InetAddress.getByName("192.168.88.2");
        System.out.println(address.getHostName());
        System.out.println(address.getHostAddress());
    }
}
