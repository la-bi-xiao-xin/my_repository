package homework3;

public class PersonTest {
    public static void main(String[] args) {
        //就业班学生类测试
        WorkStudent wc=new WorkStudent("小明",24);
        System.out.println(wc.getName()+"   年龄"+wc.getAge());
        wc.eat();
        wc.study();
        wc.speak();
        System.out.println("*******************8");
        //基础班学生类测试
        BasicStudent bc=new BasicStudent("小熊",24);
        System.out.println(bc.getName()+"   年龄"+bc.getAge());
        bc.eat();
        bc.study();
        System.out.println("*******************8");
        //就业班老师类测试
        WorkTeacher wt=new WorkTeacher("刘老师",32,100000);
        System.out.println(wt.getName()+"  年龄"+wt.getAge()+"  薪资"+wt.getSalary());
        wt.eat();
        wt.teach();
        wt.speak();
        System.out.println("*******************8");
        //基础班老师类测试
        BasicTeacher bt=new BasicTeacher("赵老师",30,90000);
        System.out.println(bt.getName()+"  年龄"+bt.getAge()+"  薪资"+bt.getSalary());
        bt.eat();
        bt.teach();
    }
}
