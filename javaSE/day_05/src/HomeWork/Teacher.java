package HomeWork;

import java.util.SplittableRandom;

/*属性:
		姓名: name
		年龄: age
		讲课内容: content
	行为:
		吃饭: eat()
		讲课: teach()
	/**/
public class Teacher {
    private String name;
    private int age;
    private String content;
    //空参构造
    public Teacher(){}
    //有参构造
    public Teacher(String name,int age,String content){
        this.name=name;
        this.age=age;
        this.content=content;

    }
    //set(),get()fangfa

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
    public void eat(){
        System.out.println("年龄为"+age+"的"+name+"老师正在吃饭");
    }
    public void teach(){
        System.out.println("年龄为"+age+"的"+name+"老师正在亢奋的讲"+content+"的内容");
    }
}
