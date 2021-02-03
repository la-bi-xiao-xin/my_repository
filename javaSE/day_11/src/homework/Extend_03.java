package homework;

import java.util.HashMap;

/*
第3题: 通过代码, 完成如下需求:
        1. 有类似这样的字符串："1.2,3.4,5.6,7.8,5.56,44.55" 请按照要求，
           依次完成以下试题
        2. 以逗号作为分隔符，把已知的字符串分成一个String类型的数组，
           数组中的每一个元素类似于"1.2","3.4"这样的字符串
        3. 把数组中的每一个元素以"."作为分隔符，把"."左边的元素作为key，
           右边的元素作为value，封装到Map中，Map中的key和value都是Integer类型
        4. 遍历集合.
*/
public class Extend_03 {
    public static void main(String[] args) {
        String s="1.2,3.4,5.6,7.8,5.56,44.55";

        //1.以逗号作为分隔符，把已知的字符串分成一个String类型的数组
       String[] arryStr= s.split(",");
        for (String s1 : arryStr) {
            System.out.print(s1+"  ");
        }
        System.out.println();
        System.out.println("**************************");

       //2.创建HashMap集合
        HashMap<String , String > hm = new HashMap<>();

        //3.把String数组中的每一个元素以"."作为分隔符，把"."左边的元素作为key
        for (String s1 : arryStr) {
            System.out.println(s1);
            String[] arrayStr2=s1.split("\\.");
            hm.put(arrayStr2[0],arrayStr2[1]);
        }
        System.out.println("********************");
        //4.根据键遍历hm集合
        for (String key : hm.keySet()) {
            System.out.println(key+"__"+hm.get(key));

        }
    }
}
