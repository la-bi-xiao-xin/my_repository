package homework2;

public abstract class Coach extends Person {
    public Coach() {
    }

    public Coach(String naem, int age) {
        super(naem, age);
    }
    public abstract void teach();
}
