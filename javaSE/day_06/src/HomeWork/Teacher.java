package HomeWork;

public class Teacher extends Person {

    public Teacher() {
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("老师喝牛肉汤");
    }
    public void techer(){
        System.out.println("老师要教课");
    }
}
