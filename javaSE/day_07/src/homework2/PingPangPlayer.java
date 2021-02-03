package homework2;

public class PingPangPlayer extends Player implements Speak {
    public PingPangPlayer() {
    }

    public PingPangPlayer(String naem, int age) {
        super(naem, age);
    }

    @Override
    public void study() {
        System.out.println("学习打乒乓球");
    }

    @Override
    public void eat() {
        System.out.println("吃乒乓球运动员特享餐");
    }

    @Override
    public void speak() {
        System.out.println("can speak english");
    }
}
