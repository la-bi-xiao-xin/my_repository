package homework2;

public abstract class Player extends Person {
    public Player() {
    }

    public Player(String naem, int age) {
        super(naem, age);
    }
   public abstract void study();
}
