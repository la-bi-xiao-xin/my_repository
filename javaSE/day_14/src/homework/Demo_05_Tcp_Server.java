package homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo_05_Tcp_Server {
    public static void main(String[] args) throws IOException {
        //1.创建服务器端ServerScoket对象
        ServerSocket ss=new ServerSocket(19951);

        //2.创建accept监听获取Socket对象
        Socket accept = ss.accept();

        //3.创建高效字符输入流给关联accept的InputStream对象
        BufferedReader br=new BufferedReader(new InputStreamReader(accept.getInputStream()));

        //4.创建高效字符输出流关联,文件目的地路径
        BufferedWriter bw=new BufferedWriter(new FileWriter("E:\\day_14\\src\\homework\\2.txt"));

        //5.循环读取accept的InputStram对象中的数据,并写入目标文件中
        String s=null;
        while ((s=br.readLine())!=null){
            bw.write(s);
            bw.newLine();
            bw.flush();
        }

        //6.创建accpet 的OutputStram 流对象反馈接收信息

        OutputStream os = accept.getOutputStream();
        os.write("文件接收成功!".getBytes());
       ss.close();
        bw.close();
    }
}
