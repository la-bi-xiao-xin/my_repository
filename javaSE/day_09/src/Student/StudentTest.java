package Student;
/*
•	public static String toString(int[] arr)
        解释: 把int类型的数组转成其对应的字符串形式.
        测试toString()实参为自定义数据类型时,返回值数据类型是否为String类,如果是是什么样的格式
        */

import java.util.Arrays;

public class StudentTest {
    public static void main(String[] args) {
        Student s1 = new Student("张三", 12);
        Student s2 = new Student("李四", 13);
        Student s3 = new Student("王五", 14);
        Student[] sArry = {s1, s2, s3};
        //int[] arry={1,2,3,};
        System.out.println(Arrays.toString(sArry));
        System.out.println("****************");
        System.out.println(s1.name);
    }
}
