package Demo;
//创建Class对象的方法

public class Demo_01 {
    public static void main(String[] args) throws Exception {
        Class<Student> c1 = Student.class;
        System.out.println(c1);
        System.out.println("**********************");

        Student s = new Student();
        Class<? extends Student> c2 = s.getClass();
        System.out.println(c2);
        System.out.println("**********************");

        Class<?> c3 = Class.forName("Demo.Student");
        System.out.println(c3);

    }
}
