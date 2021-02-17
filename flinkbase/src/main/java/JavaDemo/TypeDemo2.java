package JavaDemo;

public class TypeDemo2 {
    public static void main(String[] args) {
        A a = new A();
        //调用A的方法m时,方法的参数类型,会根据给定的参数的类型来确定
        a.m("asd");
        a.m(1);

    }
}
//定义一个类A,里面包含方法m,给方法m添加泛型
class A {

    public <T> void m(T t) {
        System.out.println(t.getClass());
    }
}