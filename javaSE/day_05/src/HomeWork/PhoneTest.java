package HomeWork;
 //创建手机类的对象, 然后访问类中的成员.
public class PhoneTest {
    public static void main(String[] args) {
        //测试空参构造
        Phone p=new Phone();
        p.setBrand("vivo");
        p.setPrice(3333);
        p.setColor("黑色");
        System.out.println(p.getBrand());
        System.out.println(p.getPrice());
        System.out.println(p.getColor());
        System.out.println("****************");
        //测试全参构造
        Phone p2=new Phone("华为",5666,"白色");
        System.out.println(p2.getBrand());
        System.out.println(p2.getPrice());
        System.out.println(p2.getColor());
        //测试方法
        p.call("张胜男");
        p.sendMessage("张胜男");
        p2.call("李白");
        p2.sendMessage("李白");
    }
}
