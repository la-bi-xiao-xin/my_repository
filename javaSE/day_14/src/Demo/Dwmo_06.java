package Demo;

import java.io.*;
import java.util.Properties;

//案例: 演示Properties集合类.
public class Dwmo_06 {
    public static void main(String[] args) throws IOException {
        //1.创建Properties 集合对象
        Properties p = new Properties();

        //2.往集合中添加元素
        p.setProperty("全类名","Demo.Student");
        p.setProperty("方法名","eat");
        p.setProperty("变量名","name");

        //3.打印集合
        System.out.println(p);
        System.out.println("*******************");
        for (Object key : p.keySet()) {
            System.out.println(key+"--"+p.get(key));

        }
        System.out.println("*****************************");
        //4.创建输出流将集合内容存入表中使用store方法
        //Properties类是一个集合类,实际上与xx.properties文件并没有直接联系,写入和加载,都依赖于store和load 方法以及IO流完成
        //创建IO流关联xx.properties地址
        FileWriter fw = new FileWriter("E:\\javaSE\\day_14\\src\\Demo\\myproperties.properties");
        p.store(fw,null);
        //4.1.获取集合元素打印
        System.out.println(p.get("全类名"));
        System.out.println("**********************************");
        //5.加载xx.properties文件中数据至Properties集合中
        FileReader fr = new FileReader("E:\\javaSE\\day_14\\src\\Demo\\myproperties.properties");

        p.load(fr);
        System.out.println(p.getProperty("方法名"));

      /*  //需求2: 往IO流(配置文件中)写数据.
        //1. 创建Properties集合类.
        Properties pp = new Properties();
        //2. 从配置文件中, 读取数据.
        pp.load(new FileInputStream("E:\\javaSE\\day_14\\src\\Demo\\myproperties.properties"));

        //3. 修改Properties集合中的数据.
        pp.setProperty("name", "dalihang");
        pp.setProperty("address", "xinxiang");

        //4. 把Properties集合中的数据, 重新写入到配置文件中.
        //第二个参数: 一般是用来记录 修改原因的, 即: 谁修改的, 为啥修改.  不能写中文, 因为会被识别成Unicode字符.
        //实际开发中, 一般是写null
        //pp.store(new FileOutputStream("day14/src/config.properties"), "夯哥, 乐意改");
        pp.store(new FileOutputStream("E:\\javaSE\\day_14\\src\\Demo\\myproperties.properties"), null);

        //3. 打印Properties集合对象.
        System.out.println(pp);*/
        System.out.println("**********************");
        char a='a';
        byte b=1;
        System.out.println(a+b);

    }
}
