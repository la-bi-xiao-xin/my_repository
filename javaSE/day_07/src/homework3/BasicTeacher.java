package homework3;

public class BasicTeacher extends Teacher {
    public BasicTeacher() {
    }

    public BasicTeacher(String name, int age, int salary) {
        super(name, age, salary);
    }
    @Override
    public void teach() {
        System.out.println("基础班老师讲JavaSE");
    }
}
