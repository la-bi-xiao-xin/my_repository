package homework2;

public class BasketballCoach extends Coach  {
    public BasketballCoach() {
    }
    public BasketballCoach(String naem, int age) {
        super(naem, age);
    }

    @Override
    public void teach() {
        System.out.println("教打篮球");
    }

    @Override
    public void eat() {

        System.out.println("吃篮球教练特享餐");
    }


}
