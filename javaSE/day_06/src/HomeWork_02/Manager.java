package HomeWork_02;

public class Manager extends Employee {
    private int bonus;

    public Manager() {
    }

    public Manager(String name, String workId, int salary, int bonus) {
        super(name, workId, salary);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public void eat() {
        System.out.println("员工餐");
    }

    @Override
    public void work() {
        System.out.println("管理工作");
    }
}
