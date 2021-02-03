package HomeWork;
/*属性:
		姓名: name
		年龄: age
		学习内容: content
	行为:
		吃饭: eat()
		学习: study()*/
public class Student {
    private String name;
    private  int age;
    private String content;

    public Student() {
    }

    public Student(String name, int age, String content) {
        this.name = name;
        this.age = age;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
public void eat(){
    System.out.println("年龄为"+age+"的"+name+"同学正在吃饭");
}
public void study(){
    System.out.println("年龄为"+age+"的"+name+"同学正在专心致志的学习"+content+"内容");
}

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", content='" + content + '\'' +
                '}';
    }
}
