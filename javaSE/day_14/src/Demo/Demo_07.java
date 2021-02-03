package Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//案例: 演示Properties结合集合类来使用.
public class Demo_07 {
    public static void main(String[] args) throws IOException {
        //1.创建Proprties 集合对象
        Properties p = new Properties();

        //2.关联文件读取数据
        p.load(new FileInputStream("E:\\day_14\\src\\Demo\\myproperties.properties"));

        //3.打印集合元素
        for (Object o : p.keySet()) {
            System.out.println(o+"="+p.get(o));

        }

    }
}
