package com.ithiema_demo_03;

public class AnimalTest {
    public static void main(String[] args) {
        //多态形式定义对象,想要调用子类特有成员,都很需要向下转型
        Animal an = new Cat();
        ((Cat) an).setColor("黑色");
        /*
       功同:
       Cat c=(Cat)an;
       c.setColor("黑色");
    */
        System.out.println(((Cat) an).getColor());
        ((Cat) an).catchMouce();
    /*
       功同:
       Cat c=(Cat)an;
       c.catchMouce();
    */
       /*Cat c=new Cat("小黄",3,"黑色");
        System.out.println(c.getColor());
*/
    }
}
