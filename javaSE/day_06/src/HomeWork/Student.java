package HomeWork;

public class Student extends Person {
    public Student() {
    }

    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("学生吃牛肉");
    }

    public void study(){
        System.out.println("学生要学习");
    }
}
