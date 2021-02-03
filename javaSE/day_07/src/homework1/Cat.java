package homework1;

public class Cat extends Animal  {
    //猫类特有属性color
    private String color;
    public Cat() {
    }

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
//父类方法重写
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }

    //猫类特有方法定义
    public void catchMouch(){
        System.out.println("猫会抓老鼠");
    }
}
