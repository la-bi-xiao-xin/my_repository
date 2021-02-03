package apitest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test_05 {
    public static void main(String[] args) throws ParseException {
      /*  String s="22-7-10 下午3:30";  //系统默认的输出时间字符串格式
        SimpleDateFormat sdt = new SimpleDateFormat();
        //采用空参构造创建的SimpleDateFormat对象时,
        // 需要解析的时间字符串格式要和系统默认的一样,不然就报错
        //所以做字符串时间的解析时,一般将要解析的字符串时间格式设为构造函数的参数
        Date date2=sdt.parse(s);
        System.out.println(date2);*/

      //解析自定义输入格式的字符串时间
        String date="2020.2.13";
        System.out.println(date);
        SimpleDateFormat sdt2 = new SimpleDateFormat("yyyy.MM.dd");
       Date date3= sdt2.parse(date);
        System.out.println(date3);

    }
}
