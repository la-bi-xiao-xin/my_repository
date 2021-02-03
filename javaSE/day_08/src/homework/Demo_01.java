package homework;

/*
需求1:
        1.定义字符数组chs, 初始化值为: 'a, 'b', 'c', 这三个字符 .
        2.将其分别封装成s1, s2这两个字符串对象.
        3.直接通过""的方式创建两个字符串对象s3和s4.
        4.通过==分别判断s1和s2, s1和s3, s3和s4是否相同.
        5.通过equals()分别判断s1和s2, s1和s3, s3和s4是否相同.
        6.通过equalsIgnoreCase()判断字符串abc和ABC是否相同.
        */
public class Demo_01 {
    public static void main(String[] args) {
        //1.定义字符数组chs, 初始化值为: 'a, 'b', 'c', 这三个字符 .
        //char[] chs=new char[]{'a','b','c'};
        char[] chs = {'a', 'b', 'c'};

        //2.将其分别封装成s1, s2这两个字符串对象.
        String s1 = new String(chs);
        String s2 = new String(chs);

        // 3.直接通过""的方式创建两个字符串对象s3和s4.
        String s3="abc";
        String s4="abc";
        //4.通过==分别判断s1和s2, s1和s3, s3和s4是否相同.
        System.out.println(s1 == s2);   //预测 false     理解:"=="比较的是地址
        System.out.println(s1 == s3);   //预测 false     通过构造传字符数组创建的对象,不论值是否相等,都会单独开辟空间并给出地址
        System.out.println(s3 == s4);   //预测 true      通过""创建的对象,放在常量池,因为字符串优化机制,只要常量池内已经有的值,后来再创建就延用原来的地址和内容
        System.out.println("***************************");
        //5.通过equals()分别判断s1和s2, s1和s3, s3和s4是否相同.
        System.out.println(s1.equals(s2));  //预测 true    理解:equals()方法比较的是对象属性我简单理解为是在比较内容
        System.out.println(s1.equals(s3));  //预测 true       s1 和 s3 对象内容相等即为true
        System.out.println(s3.equals(s4));  //预测 true
        System.out.println("***************************");

        //6.通过equalsIgnoreCase()判断字符串abc和ABC是否相同.
        String s5="abc";
        String s6="ABC";
        System.out.println(s5.equalsIgnoreCase(s6));//预测 true     equalsIgnoreCase()方法比较内容不区分大小写的
        System.out.println(s6.equals(s5));           //预测 false    equals()方法比较内容区分大小写

    }
}
