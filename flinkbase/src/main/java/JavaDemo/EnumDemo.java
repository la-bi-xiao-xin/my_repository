package JavaDemo;

public enum  EnumDemo {
    ADD,

    DROP,

    MODIFY,

    CHANGE,

    ALTER;

    //获取枚举项字符串

    public final String getAlterType(){return this.toString();}


}
    class EnumUser{
    public static void main(String[] args) {
        EnumDemo add1 = EnumDemo.ADD;
        System.out.println(add1);

        //打印结果ADD

        String add = EnumDemo.ADD.getAlterType();
        System.out.println(add);

        //打印结果:ADD


        //打印结果显示的是一样的,但实际是不一样的,一个是EnumDemo对象的toString的值,一个是String对象的toString的值

    }
}