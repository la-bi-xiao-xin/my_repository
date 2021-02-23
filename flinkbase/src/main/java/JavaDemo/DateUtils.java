package JavaDemo;

import java.util.Date;
import java.util.Locale;

public class DateUtils {
   /* private String weeks;
    String uppermonth;
    String lowermonth;
    String year;*/
    //获取当前时间
   // Date today = new Date();
    //获取当前日期
   public static String getDate(Date date){
       String dates = String.format("%td", date);
       return dates;

   }
    //获取当前礼拜数
    public static String getWeeks(Date date){
        String weeks = String.format(Locale.US, "%tB", date);
        return weeks;

    }

    //获取当前月份
    public static String getMonth(Date date){
        String months = String.format("%tm", date);
        return months;

    }

    //获取当前年份

    public static String getYears(Date date){
        String years = String.format("%tY", date);
        return years;

    }
}
