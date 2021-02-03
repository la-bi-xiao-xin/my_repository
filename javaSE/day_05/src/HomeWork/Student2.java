package HomeWork;
/*属性:
			学员编号: 	String id
			姓名: 	  	String name
			性别:		String gender
			身高:		double height
			年龄:		int age
		行为:
			学习: study()
			吃饭: eat()*/
public class Student2 {
    private String id;
    private String name;
    private String gender;
    private double height;
    private int age;

    public Student2() {
    }

    public Student2(String id, String name, String gender, double height, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.height = height;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void eat(){
        System.out.println("学习饿了要吃饭.");
    }

    public void study() {
        System.out.println("编号为"+id+", 姓名为"+name+", 性别为"+gender+", 身高为"+height+"cm, 年龄为"+age+"岁的学生, 正在努力的敲代码, 学习JavaSE相关的知识点. ");
    }
}
