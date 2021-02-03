package homework2;
/*
2. 已知有乒乓球运动员(PingPangPlayer)和篮球运动员(BasketballPlayer), 乒乓球教练(PingPangCoach)和篮球教练(BasketballCoach).
        他们都有姓名和年龄, 都要吃饭, 但是吃的东西不同.
        乒乓球教练教如何发球, 篮球教练教如何运球和投篮.
        乒乓球运动员学习如何发球, 篮球运动员学习如何运球和投篮.
        为了出国交流, 跟乒乓球相关的人员都需要学习英语.
        请用所学, 模拟该知识.
        */
public class PersonTest {
    public static void main(String[] args) {
        //测试乒乓球运动员
        PingPangPlayer ppp=new PingPangPlayer("张继科",28);
        System.out.println(ppp.getNaem()+"   年龄"+ppp.getAge());
        ppp.eat();
        ppp.study();
        ppp.speak();
        System.out.println("***************");
        //测试篮球运动员
        BasketballPlayer bp=new BasketballPlayer("科比",42);
        System.out.println(bp.getNaem()+"   年龄"+bp.getAge());
        bp.eat();
        bp.study();
        System.out.println("***************");
        //测试乒乓球教练
        PingPangCoach ppc=new PingPangCoach("刘国梁",45);
        System.out.println(ppc.getNaem()+"  年龄"+ppc.getAge());
        ppc.eat();
        ppc.teach();
        ppc.speak();
        System.out.println("***************");
        //测试篮球教练
        BasketballCoach bc=new BasketballCoach("德尔哈里斯",67);
        System.out.println(bc.getNaem()+"   年龄"+bc.getAge());
        bc.eat();
        bc.teach();
    }
}
