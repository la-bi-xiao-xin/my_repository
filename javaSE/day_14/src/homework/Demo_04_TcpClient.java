package homework;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
•	案例需求
 	   客户端：发送数据，接受服务器反馈
 	   服务器：收到消息后给出反馈
	案例分析
	  客户端创建对象，使用输出流输出数据
	  服务端创建对象，使用输入流接受数据
	  服务端使用输出流给出反馈数据
	  /客户端使用输入流接受反馈数据

*/
public class Demo_04_TcpClient {
    public static void main(String[] args) throws Exception {
        //1. 创建客户端的Socket对象, 指定: 服务器端的IP, 端口号.
        Socket clientSocket = new Socket("127.0.0.1", 10088);
        //2. 通过Socket#getOutputStream(), 获取输出流对象, 可以往服务器端写数据.
        byte[] bytes = "我是客户端,请求发送数据".getBytes();
        OutputStream clientOs = clientSocket.getOutputStream();
        clientOs.write(bytes);

        byte[] bytes1 = new byte[1024];
        InputStream clientIs = clientSocket.getInputStream();
        int len = clientIs.read(bytes1);
        System.out.println(new String(bytes1, 0, len));

        //3. 关闭Socket对象.  Socket#close();
        clientSocket.close();
    }

}
