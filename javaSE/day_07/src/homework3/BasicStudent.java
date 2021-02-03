package homework3;

public class BasicStudent extends Student  {
    public BasicStudent() {
    }

    public BasicStudent(String name, int age) {
        super(name, age);
    }

    @Override
    public void study() {
        System.out.println("基础班学生学习JavaSE");
    }
}
