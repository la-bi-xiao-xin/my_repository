package HomeWork;

import java.util.Scanner;

/*4. 控制台输出结果格式如下:
		请录入学生的编号:
		...		//这里是用户录入的内容
		请录入学生的姓名:
		...
		请录入学生的性别:
		...
		请录入学生的身高:
		...
		请录入学生的年龄:
		...

		编号为222, 姓名为张三, 性别为男, 身高为175.3cm, 年龄为23岁的学生, 正在努力的敲代码, 学习JavaSE相关的知识点.
		学习饿了要吃饭.
 */
public class Student2Test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Student2 s2=new Student2();
        System.out.println("请录入学生的编号:");
        s2.setId(sc.nextLine());
        System.out.println("请录入学生的姓名:");
        s2.setName(sc.nextLine());
        System.out.println("请录入学生的性别:");
        s2.setGender(sc.nextLine());
        System.out.println("请录入学生的身高:");
        s2.setHeight(sc.nextDouble());
        System.out.println("请录入学生的年龄:");
        s2.setAge(sc.nextInt());
        s2.study();
    }
}
