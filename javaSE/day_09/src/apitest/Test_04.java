package apitest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test_04 {
    public static void main(String[] args) {
        Date d1 = new Date();
        System.out.println(d1);
        System.out.println("**********************");
        SimpleDateFormat sdt = new SimpleDateFormat();
        //空参构造,格式化Date数据,则返回系统默认的模板显示Date对象
        System.out.println("**********************");
        String s=sdt.format(d1);
        System.out.println(s);
       /* SimpleDateFormat sdt2 = new SimpleDateFormat("yyyy年MM月dd号");
        //带参构造,格式化Date数据,则返回构造方法参数的模板Date对象
        System.out.println(sdt2.format(d1));
        System.out.println("**********************");*/




    }
}
