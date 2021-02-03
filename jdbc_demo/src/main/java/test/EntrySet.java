package test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EntrySet {
    @Test
    public void test(){
        HashMap hashMap = new HashMap<String,String>();

        hashMap.put("张三","12");
        hashMap.put("李四","22");
        hashMap.put("王五","32");
        //Set set = hashMap.entrySet();
        //System.out.println(set);

    }
}
