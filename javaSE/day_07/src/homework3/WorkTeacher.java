package homework3;

public class WorkTeacher extends Teacher implements Speak {
    public WorkTeacher() {
    }

    public WorkTeacher(String name, int age, int salary) {

        super(name, age, salary);
    }
    @Override
    public void teach() {

        System.out.println("就业班老师讲JavaEE, Hadoop, Hive, Scala, Flink, Spark等");
    }

    @Override
    public void speak() {
        System.out.println("can speak english");
    }
}
