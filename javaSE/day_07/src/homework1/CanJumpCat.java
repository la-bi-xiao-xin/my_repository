package homework1;

public class CanJumpCat extends Cat implements Jump{
    public CanJumpCat() {
    }

    public CanJumpCat(String name, int age, String color) {
        super(name, age, color);
    }

    @Override
    public void jump() {
        System.out.println("猫式跳高");
    }
}
