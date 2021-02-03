package apitest;

import java.util.Date;

public class Test_03 {
    public static void main(String[] args) {
      /*  Date d=new Date();
        System.out.println(d);
        System.out.println(d.getTime());
        d.setTime(100000L);
        System.out.println(d);
        System.out.println(d.getTime());*/
        Date d2 = new Date(100000);
        d2.setTime(5000);
        System.out.println(d2.getTime());
    }
}
