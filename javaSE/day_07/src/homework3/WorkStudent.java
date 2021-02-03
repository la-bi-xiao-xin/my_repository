package homework3;

public class WorkStudent extends Student implements Speak {
    public WorkStudent() {
    }

    public WorkStudent(String name, int age) {
        super(name, age);
    }

    @Override
    public void speak() {
        System.out.println("can speak english");
    }

    @Override
    public void study() {
        System.out.println("就业班学生学习JavaEE, Hadoop, Hive, Scala, Flink, Spark等");
    }
}
