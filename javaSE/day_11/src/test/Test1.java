package test;

import java.util.ArrayList;
import java.util.HashMap;

public class Test1 {
    public static void main(String[] args) {
        //1.定义ArrayList<HashMap<String, String>>集合, 存储三个元素, 每个元素都是一个双列集合, 具体如下:
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        //2.第一个双列集合, 记录的信息如下:
        HashMap<String, String> sgyy = new HashMap<>();
        sgyy.put("孙策", "大乔");
        sgyy.put("周瑜", "小乔");

        //3.第二个双列集合, 记录的信息如下:
        HashMap<String, String> sdxl = new HashMap<>();
        sdxl.put("郭靖", "黄蓉");
        sdxl.put("杨过", "小龙女");

        //4.第三个双列集合, 记录的信息如下:
        HashMap<String, String> xajh = new HashMap<>();
        xajh.put("令狐冲", "任盈盈");
        xajh.put("林平之", "岳灵珊");

        //5.把上述的三个双列集合当做元素对象, 添加到ArrayList集合中.
        list.add(sgyy);
        list.add(sdxl);
        list.add(xajh);

        //6.遍历ArrayList集合, 输出每个元素.
        //6.1 遍历List集合, 获取其每一个元素.
        for (HashMap<String, String> hm : list) {
            //6.2 因为List集合的每个元素都是: 双列集合, 所以我们接着遍历.
            //这里我采用根据键获取值的方式遍历.
            //6.3 获取双列集合中所有的键, 然后遍历, 获取到每一个键.
            for (String key : hm.keySet()) {
                //6.4 打印键和值的结果.
                System.out.println(key + "..." + hm.get(key));
            }
            //每打印完一个双列集合, 我们就来一个换行,
            System.out.println();
        }
    }
}
