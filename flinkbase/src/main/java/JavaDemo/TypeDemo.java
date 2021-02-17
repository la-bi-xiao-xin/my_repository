package JavaDemo;

public class TypeDemo {
    public static void main(String[] args) {

        A<String> stringA = new A<String>();
        A<Integer> a = new A<Integer>();


    }
    //在类名后面加上泛型<T>
    public static class A<T>{
        //使得成员变量的类型可以根据,创建对象时给定的数据类型来确定
        T a;

        public A() {
        }

        public A(T a) {
            this.a = a;
        }

        public T getA() {
            return a;
        }

        public void setA(T a) {
            this.a = a;
        }


    }
}
