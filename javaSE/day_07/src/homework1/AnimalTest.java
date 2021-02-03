package homework1;
/*
1 已知有猫类和狗类, 它们都有姓名和年龄, 都要吃饭, 不同的是猫吃鱼, 狗吃肉.
        它们都有跑步的功能, 而且仅仅是跑步, 并无任何区别.
        猫独有自己的功能: 抓老鼠catchMouse(), 狗独有自己的功能: 看家lookHome()
        部分的猫和狗经过马戏团的训练后, 学会了跳高jump(), 请用所学, 模拟该知识

        这题怎么做到部分猫和狗调高?
        创建猫狗的子类在实现接口,在调用会跳高的猫
        .*/
public class AnimalTest {
    public static void main(String[] args) {
        //猫类空参测试
        CanJumpCat c=new CanJumpCat();
        c.setName("小黑");
        c.setAge(3);
        c.setColor("黑色");
        System.out.println(c.getName()+"  年龄"+c.getAge()+"  "+c.getColor());
        c.run();
        c.eat();
        c.jump();
        c.catchMouch();
        System.out.println("*****************************");
        //猫类全参测试
        CanJumpCat c2=new CanJumpCat("小花",2,"花色");
        System.out.println(c2.getName()+"  年龄"+c2.getAge()+"  "+c2.getColor());
        c2.run();
        c2.eat();
        c2.jump();
        c2.catchMouch();
        System.out.println("***************");
        //狗类全参测试
        CanJumpDog d=new CanJumpDog("小汪",3);
        System.out.println(d.getName()+"   年龄"+d.getAge());
        d.run();
        d.eat();
        d.jump();
        d.lookHome();

    }


}
