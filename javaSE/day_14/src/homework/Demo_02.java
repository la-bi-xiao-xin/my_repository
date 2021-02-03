package homework;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo_02 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("DESKTOP-CAADNR7");
        System.out.println(inetAddress.getHostName());
        System.out.println(inetAddress.getHostAddress());
    }
}
