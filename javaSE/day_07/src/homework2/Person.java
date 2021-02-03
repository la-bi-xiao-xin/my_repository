package homework2;
//人类
public abstract class Person {
    //属性
    private String naem;
    private int age;
//构造方法
    public Person() {
    }

    public Person(String naem, int age) {
        this.naem = naem;
        this.age = age;
    }

    //成员方法
    public String getNaem() {
        return naem;
    }

    public void setNaem(String naem) {
        this.naem = naem;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public abstract void eat();
}
