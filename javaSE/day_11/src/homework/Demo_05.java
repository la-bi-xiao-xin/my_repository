package homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
第五题: 通过代码, 完成如下需求:
        1. 创建HashMap集合, 键是学生对象(Student), 值是居住地(String).
        2. 往HashMap集合中添加3组数据.
        3. 通过两种方式, 遍历HashMap集合.
                细节: Map集合的的特点是: 无序, 键具有唯一性, 元素无索引.
                Set集合的底层依赖的也是Map集合.
                代码只要做一件事儿: 让Student类去重写: hashCode(), equals().
*/
public class Demo_05 {
    public static void main(String[] args) {
        //1. 创建HashMap集合, 键是学生对象(Student), 值是居住地(String).
        HashMap<Student, String> hm = new HashMap<>();

        //2. 往HashMap集合中添加3组数据.
        hm.put(new Student("张三", 34), "深圳");
        hm.put(new Student("李四", 36), "北京");
        hm.put(new Student("赵薇", 35), "上海");
        System.out.println(hm);
        System.out.println("**********************************************");

        //3. 通过两种方式, 遍历HashMap集合.
        //3.1 方式一: 根据键获取值.
        Set<Student> keyset = hm.keySet();   //获取键单列集合
        for (Student key : keyset) {           //增强for遍历键的单列集合
            System.out.println("键值为:" + key + "   值为:" + hm.get(key));    //同过键获取值

        }
        System.out.println("**********************************************");

        //3.2 方式二: 根据键值对对象获取键和值.
        Set<Map.Entry<Student, String>> entrySet = hm.entrySet(); //获取键值对对象单列集合
        for (Map.Entry<Student, String> entry : entrySet) {        //遍历键值对对象单列集合
            System.out.println("键值为:" + entry.getKey() + "   值为:" + entry.getValue());                 //获取键值对对象的值
        }
    }
}
