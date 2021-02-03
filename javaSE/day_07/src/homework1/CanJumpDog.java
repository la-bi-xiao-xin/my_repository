package homework1;

public class CanJumpDog extends Dog implements Jump {
    public CanJumpDog() {
    }

    public CanJumpDog(String name, int age) {
        super(name, age);
    }

    @Override
    public void jump() {
        System.out.println("狗式跳高");
    }
}
