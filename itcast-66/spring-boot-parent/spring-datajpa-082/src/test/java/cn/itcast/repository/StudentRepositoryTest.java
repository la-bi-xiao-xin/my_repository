package cn.itcast.repository;

import cn.itcast.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)  //注解 springboot中测试环境
@SpringBootTest //注解 标记此类为springboot 测试类
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void save(){
        Student student = new Student();
        student.setName("张一山");
        student.setAge(55);
        student.setSex("男");
        Student student1 = studentRepository.save(student);
    }

    @Test
    public void findByIdIn(){
        ArrayList<Integer> idList = new ArrayList<>();
        idList.add(1);
        idList.add(2);
        idList.add(3);
        List<Student> studentList = studentRepository.findByIdIn(idList);
        for (Student student : studentList) {
            System.out.println("+++++++++++++++");
            System.out.println(student);
        }
    }

}