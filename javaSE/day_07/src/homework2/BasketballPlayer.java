package homework2;

public class BasketballPlayer extends Player {
    public BasketballPlayer() {
    }

    public BasketballPlayer(String naem, int age) {

        super(naem, age);
    }

    @Override
    public void study()
    {
        System.out.println("学习打篮球");
    }

    @Override
    public void eat() {

        System.out.println("吃篮球运动员特享餐");
    }

}
