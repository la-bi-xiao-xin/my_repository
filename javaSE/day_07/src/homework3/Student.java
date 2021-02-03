package homework3;

public abstract class Student extends Person {
    public Student() {
    }

    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("学生吃学生餐");
    }
    public abstract void study();
}
