package homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*第六题: 通过代码, 完成如下需求:
        1. 定义ArrayList<HashMap<String, String>>集合, 存储三个元素,
        每个元素都是一个双列集合, 具体如下:
        2. 第一个双列集合, 记录的信息如下:
        孙策	大乔
        周瑜	小乔
        3. 第二个双列集合, 记录的信息如下:


        4. 第三个双列集合, 记录的信息如下:


        5. 把上述的三个双列集合当做元素对象, 添加到ArrayList集合中.
        6. 遍历ArrayList集合, 输出每个元素.*/
public class Demo_06 {
    public static void main(String[] args) {
        //1. 定义ArrayList<HashMap<String, String>>集合, 存储三个元素,
        ArrayList<HashMap<String, String>> alist = new ArrayList<>();

        //2.1第一个双列集合, 记录的信息
        HashMap<String, String> hm1 = new HashMap<>();
        hm1.put("郭靖", "黄蓉");
        hm1.put("杨过", "小龙女");

        //2.2第一个双列集合, 记录的信息
        HashMap<String, String> hm2 = new HashMap<>();
        hm2.put("孙策", "大乔");
        hm2.put("周瑜", "小乔");

        //2.3第一个双列集合, 记录的信息
        HashMap<String, String> hm3 = new HashMap<>();
        hm3.put("令狐冲", "任盈盈");
        hm3.put("林平之", "岳灵珊");

        //3.把上述的三个双列集合当做元素对象, 添加到ArrayList集合中.
        alist.add(hm1);
        alist.add(hm2);
        alist.add(hm3);

        //4. 遍历ArrayList集合, 输出每个元素.
        //4.1 方式一 获取键值的方式遍历
        for (HashMap<String, String> map1 : alist) {
            for (String key : map1.keySet()) {
                System.out.println(key + "---" + map1.get(key));
            }
            System.out.println();
        }
        System.out.println("************************************");

        //4.2 方式二 获取键值对的方式遍历
        for (HashMap<String, String> map2 : alist) {
            System.out.println("");
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                System.out.println(entry.getKey() + "---" + entry.getValue());
            }
            System.out.println();
        }
    }
}
