package JavaDemo;

import java.util.Date;

public class DateUtilsTest {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(DateUtils.getDate(date));

        System.out.println(DateUtils.getWeeks(date));

        System.out.println(DateUtils.getMonth(date));

        System.out.println(DateUtils.getYears(date));
    }
}
