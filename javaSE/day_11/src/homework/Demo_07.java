package homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
第七题: 通过代码, 完成如下需求:
        1. 创建一个HashMap集合，存储三个键值对元素，键表示书名(String)，
        值是书中人物名(ArrayList<String>)
        2. 第一个ArrayList集合的元素: (三国演义)
        诸葛亮
        赵云
        3. 第二个ArrayList集合的元素: (西游记)
        唐僧
        孙悟空
        4. 第三个ArrayList集合的元素: (水浒传)
        武松
        鲁智深
        5. 遍历HashMap集合, 输出每一个元素.
        */
public class Demo_07 {
    public static void main(String[] args) {
        //1. 创建一个HashMap集合，存储三个键值对元素，键表示书名(String)，
        //值是书中人物名(ArrayList<String>)
        HashMap<String, ArrayList<String>> hm = new HashMap<>();

        //2.1 创建第一个ArrayList 集合 ,并添加元素
        ArrayList<String> sgyy = new ArrayList<String>();
        sgyy.add("诸葛亮");
        sgyy.add("赵云");

        //2.2 创建第二个ArrayList 集合 ,并添加元素
        ArrayList<String> xyj = new ArrayList<String>();
        xyj.add("唐僧");
        xyj.add("孙悟空");

        //2.3 创建第三个ArrayList 集合 ,并添加元素
        ArrayList<String> shz = new ArrayList<String>();
        shz.add("武松");
        shz.add("鲁智深");

        //4.向HashMap集合中添加元素
        hm.put("三国", sgyy);
        hm.put("西游记", xyj);
        hm.put("水浒传", shz);
        System.out.println(hm);
        System.out.println("****************************");

        //5.遍历HashMap集合, 输出每一个元素.
        //5.1 通过获取键遍历集合
        Set<String> keySet = hm.keySet();
        for (String key : keySet) {
            System.out.println(key);
            for (String s : hm.get(key)) {
                System.out.println(s);

            }
            System.out.println("_________");
        }
        System.out.println("*************************************");

        // 5.2通过获取键值对遍历集合
        for (Map.Entry<String, ArrayList<String>> entry : hm.entrySet()) {
            System.out.println(entry.getKey());
            for (String s : entry.getValue()) {
                System.out.println(s);

            }
            System.out.println("___________");
        }

    }
}
