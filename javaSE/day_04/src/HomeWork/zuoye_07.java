package HomeWork;
//7. 定义Demo07类, 在main方法中调用printHelloWorld()方法, 用来打印3次HelloWorld.
/*
所用知识点回顾;
        方法的四种类型:
             1.无参无返回
             格式:修饰符 void 方法名(){ 方法体 }
             2.无参有返回
             格式:修饰符 返回数据类型 方法名(){ 方法体 }
             3.有参无返回
             格式: 修饰符 void 方法名( 数据类型 参数1,数据类型 参数2,..){ 方法体 }
             4.有参有返回
             式:修饰符 返回数据类型 方法名(数据类型 参数1,数据类型 参数2,...){ 方法体}
        注意:方法与方法之间是平级关系,不可嵌套定义
方法重载的概念;
                同一类中出现方法名相同,参数列表不同的方法,称为方法的重载
                注意:方法重载的认定与返回值数据类型无关
                作用:减少类似功能重复变更命名的麻烦
*/

import java.util.Scanner;

public class zuoye_07 {
    public static void main(String[] args) {
        /*
        调用方法记住3点:
                        1.明确调用方法名
                        2.明确方法参数列表是否传参,
                         参数数据类型及个数必须与方法参数列表要求一致
                        3.接收方法返回数据,需明确方法返回数据类型
        */
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入打印次数");
        int a=sc.nextInt();
        printHelloWorld(a);
    }

    /*
    创建方法记住三个点:
                    1.明确方法名
                    2.明确参数列表
                    3.明确返回值数据类型
    */
    public static void printHelloWorld(int a) {
        for (int i = 0; i <a; i++) {
            System.out.println("HelloWorld "+(i+1));
        }
    }
}
