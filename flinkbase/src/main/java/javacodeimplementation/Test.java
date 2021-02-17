package javacodeimplementation;

public class Test {

    public static void main(String[] args) {
        Child child = new Child();
        child.sayHello();
        Parent child1 = child;
        child1.sayHello();

        System.out.println(child.getClass().getPackage().getName());

    }
}
