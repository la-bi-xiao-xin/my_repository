package HomeWork_03;

public class Dog extends Animal {

    public Dog() {
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("狗吃肉");
    }
    public void lookHome(){
        System.out.println("狗会看家");
    }
}