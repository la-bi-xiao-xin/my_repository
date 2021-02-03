package homework;
/*
1. 已知字符串"woaiheima,buguanheimahaishibaima,zhaodaogongzuojiushihaoma",
        将"heima"字符串在上述字符串中出现的次数打印到控制台上.
*/
public class DemoExpend {
    public static void main(String[] args) {
        String s="woaiheima,buguanheimahaishibaima,zhaodaogongzuojiushihaoma";
        //方法一
        System.out.println(s.split("heima").length - 1);
        /*
        String[] arrtStr=s.split("heima");
        System.out.println(arrtStr.length - 1);
        */
        //方法2

    }
}
