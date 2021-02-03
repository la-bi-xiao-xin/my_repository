package HomeWork_02;

public class Coder extends Employee {

    public Coder() {
    }

    public Coder(String name, String workId, int salary) {
        super(name, workId, salary);
    }

    @Override
    public void eat() {
        System.out.println("员工餐");
    }

    @Override
    public void work() {
        System.out.println("写代码");
    }
}
