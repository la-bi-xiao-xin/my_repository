package homework;

import java.util.Arrays;

/*
2. 已知字符串String s = "91 27 45 38 50";
        请通过代码实现最终输出结果是: "27, 38, 45, 50, 91"
*/
public class Demo_02 {
    public static void main(String[] args) {
        //String s=new String();
        //s="91 27 45 38 50";
        //语法糖,可直接写成下列形式
        String s = "91 27 45 38 50";
        //将字符串,用正则表达式拆分成字符串数组
        String[] strArr = s.split(" ");
        //将字符串数组转换成int类型数组
        int[] a = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            Integer i1 = new Integer(strArr[i]);
            a[i] = i1.parseInt(strArr[i]);
        }
        //将int[] a,升序排序
        Arrays.sort(a);
        //创建StriingBuilder对象,拼接字符串
        /*Arrays.toString(a);
        StringBuilder sb = new StringBuilder(Arrays.toString(a));
        System.out.println(sb);*/
        StringBuilder sb = new StringBuilder("\"");
        for (int i = 0; i <a.length ; i++) {
            if(i<a.length-1)
            sb.append(a[i]+",");
            else
                sb.append(a[i]+"\"");

        }
        System.out.println(sb);
    }


}


