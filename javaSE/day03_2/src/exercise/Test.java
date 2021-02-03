package exercise;

public class Test {
    String name;
    int age;

    public Test() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void sayHello() {
        System.out.println("sayHello");
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.setName("张三");
        test.setAge(35);
        test.sayHello();
        System.out.println(test.name+test.age);
    }
}
