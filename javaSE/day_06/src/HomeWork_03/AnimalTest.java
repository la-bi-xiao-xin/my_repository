package HomeWork_03;
/*
3. 已知猫和狗都有姓名和年龄, 且都有吃饭的方法, 不同的吃: 猫吃鱼, 狗吃肉.
它们都有跑步的方法, 而且仅仅是跑步.
        猫独有自己的抓老鼠(catchMouse)的功能, 狗独有自己的看门(lookHome)的功能.
        请用所学, 模拟该知识.
*/

/*
 需求分析:
  猫类
       成员变量:名字,年龄
       成员方法:吃饭,跑步
  狗类
       成员变量:名字,年龄
       成员方法:吃饭,跑步

  父类抽取
  Animal类
        成员变量:名字,年龄
        成员方法:吃饭,跑步

  */
public class AnimalTest {
    public static void main(String[] args) {
        //测试猫类     采用多态形式
        //空参测试
        //1.多态形式创建猫类对象
        Animal an=new Cat();
        //2.set()方法给成员变量赋值
        an.setName("黑猪");
        an.setAge(3);
        //3.打印成员变量
        System.out.println(an.getName()+" 年龄"+an.getAge() );
        //4.调用成员方法
        an.run();
        an.eat();
        Cat c=(Cat)an;
        c.catchMouse();
        System.out.println("*********************");
        //全参测试
        //1.多态方式创建对象并初始化成员变量
        Animal an2=new Cat("绿狗",2);
        //2.打印成员变量
        System.out.println(an2.getName()+" 年龄"+an2.getAge() );
        //3.调用成员方法
        an2.run();
        an2.eat();
        Cat c2=(Cat)an2;
        c2.catchMouse();
        System.out.println("*********************");
        //测试狗类     采用多态形式
        //空参测试 多态形式
        //1.多态形式创建对象
        Animal an3=new Dog();
        //2.set()方法给成员变量赋值
        an3.setName("瞎驴");
        an3.setAge(1);
        //3.打印成员变量
        System.out.println(an3.getName()+" 年龄"+an3.getAge() );
        //4.调用成员方法
        an3.run();
        an3.eat();
        Dog d=(Dog)an3;
        d.lookHome();
        System.out.println("*********************");
        //全参测试
        //1.多态形式创建对象
        Animal an4=new Dog("笨熊",2);
        //2.打印成员变量
        System.out.println(an4.getName()+" 年龄"+an4.getAge() );
        //3.调用成员方法
        an4.run();
        an4.eat();
        Dog d2=(Dog)an4;
        d2.lookHome();
    }
}
