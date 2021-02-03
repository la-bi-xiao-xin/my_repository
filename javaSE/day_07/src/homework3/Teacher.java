package homework3;

public abstract class Teacher extends Person {
    private int salary;
    public Teacher() {
    }

    public Teacher(String name, int age, int salary) {
        super(name, age);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public void eat() {
        System.out.println("老师吃教师餐");
    }
    public abstract void teach();
}
