package HomeWork;
/*1. 定义手机类Phone, 属性和行为如下, 并在测试类PhoneTest中, 创建手机类的对象, 然后访问类中的成员.
	属性:
		品牌: brand
		价格: price
		颜色: color
	行为:
		打电话: call(String name)			//该方法接收一个"姓名"参数, 输出格式为:  给张三打电话...
		发短信: sendMessage(String name)	//该方法接收一个"姓名"参数, 输出格式为:  给张三发短信...
		*/
public class Phone {
    //1.成员变量   私有化
    private String brand;
    private double price;
    private String color;
    //2.空参构造
    public Phone(){}
    //3.全参构造
    public Phone(String brand,double price,String color){
        this.brand=brand;
        this.price=price;
        this.color=color;
    }
    //4.getxx(),setxx()方法构造
    public void setBrand(String brand){
        this.brand=brand;
    }
    public String getBrand(){
        return brand;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public double getPrice(){
        return price;
    }
    public void setColor(String color){
        this.color=color;
    }
    public String getColor(){
        return color;
    }
    //5.成员方法
    public void call(String name){
        System.out.println("给"+name+"打电话");
    }
    public void sendMessage(String name){
        System.out.println("给"+name+"打电话");
    }
}
