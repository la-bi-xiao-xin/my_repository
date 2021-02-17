package JavaDemo;

import java.util.ArrayList;
import java.util.List;

public class FanxingDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        //list.add(1);
        for (Object o : list) {
            if(o instanceof String){
                String str = (String) o;
            }else if(o instanceof Long){
                Integer i = (Integer) o;

            }
        }
    }
}
