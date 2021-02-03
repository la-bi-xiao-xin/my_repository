package test;

import java.util.HashMap;

public class Map2Array {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("1","张三");
        hashMap.put("2","李四");
        hashMap.put("3","王五");
        hashMap.put("4","赵六");

       // String[] strings = hashMap.keySet().toArray(new String[]{});
        Object[] strings = hashMap.keySet().toArray();
        System.out.println(strings);

        System.out.println("************************************");

        for (Object string : strings) {
            System.out.println(string);
        }

    }
}
