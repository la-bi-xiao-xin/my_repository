package homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
第四题: 通过代码, 完成如下需求:
        1. 创建HashMap集合, 键是学号(String), 值是学生对象(Student).
        		//姓名, 年龄.
        2. 往HashMap集合中添加3组数据.
        3. 通过两种方式, 遍历HashMap集合.
        方式一: 根据键获取值.
        方式二: 根据键值对对象获取键和值.
        */
public class Demo_04 {
    public static void main(String[] args) {
        //1.创建HashMap集合, 键是学号(String), 值是学生对象(Student).
        HashMap<String, Student> hm = new HashMap<>();

        //2.创建Student类对象,并添加至HashMap集合中去
        hm.put("0001", new Student("刘亦菲", 34));
        hm.put("0002", new Student("贾静雯", 36));
        hm.put("0003", new Student("高圆圆", 35));
        System.out.println(hm);
        System.out.println("******************************************");

        //3. 通过两种方式, 遍历HashMap集合.
        //3.1 方式一: 根据键获取值.
        Set<String> setKey = hm.keySet(); //获取键集合
        for (String key : setKey) {     //增强for遍历键集合
            System.out.println("键值为:" + key + "  值为:" + hm.get(key)); //根据键获取值
        }
        System.out.println("******************************************");

        //3.2 方式二: 根据键值对对象获取键和值.
        Set<Map.Entry<String, Student>> entrySet = hm.entrySet(); //获取键值对 对象的集合
        for (Map.Entry<String, Student> entry : entrySet) {       //遍历获取的键值对 对象集合
            System.out.println("键值为:" + entry.getKey() + "  值为:" + entry.getValue());                 //获取键值对象中的值
        }
    }
}
