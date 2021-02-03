package homework2;

public class PingPangCoach extends Coach implements Speak {
    public PingPangCoach() {
    }
    public PingPangCoach(String naem, int age) {
        super(naem, age);
    }

    @Override
    public void teach() {
        System.out.println("教打乒乓球");
    }

    @Override
    public void eat() {

        System.out.println("吃乒乓球教练特享餐");
    }

    @Override
    public void speak() {
        System.out.println("can speak english");
    }
}
