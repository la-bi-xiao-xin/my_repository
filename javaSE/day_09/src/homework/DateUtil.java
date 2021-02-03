package homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//DateUtil 工具类
public class DateUtil {
    //构造方法私有化
    private DateUtil() {
    }
    //date2String()方法
    public static String date2String(Date d, String pattern) {
        //按照给定格式,创建 SimpleDateFormat类对象
        SimpleDateFormat sdt = new SimpleDateFormat(pattern);
        //传入Date类对象d,format()方法会按照pattern 的格式输出字符串时间
        String date = sdt.format(d);
        return date;
    }

    public static Date string2Date(String sDate, String pattern) throws ParseException {
        /*
        创建SimpleDateFormat类的对象,且给定参数pattern,只有传入了pattern同样格式的字符串时间
         后面的parse()方法才能返回Date类型结果,这就意味着创建SimpleDateFormat类的对象时给的参数pattern
        和后面要要转换的字符串时间sDate的格式要一样,例如:
        sDate是"HH:mm:ss"形式的   pattern也要是"HH:mm:ss"形式
        */
        SimpleDateFormat sdt = new SimpleDateFormat(pattern);
        Date date = sdt.parse(sDate);
        return date;
    }
}
