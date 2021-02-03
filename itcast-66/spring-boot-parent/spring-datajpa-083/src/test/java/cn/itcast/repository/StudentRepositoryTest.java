package cn.itcast.repository;

import cn.itcast.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void save(){
        Student student1 = new Student();
        student1.setName("小芳");
        student1.setAge(25);
        student1.setSex("女");
        Student student = studentRepository.save(student1);
    }

    @Test
    public void findByIdIn(){
        ArrayList<Integer> idList = new ArrayList<>();
        idList.add(1);
        idList.add(2);
        List<Student> students = studentRepository.findByIdIn(idList);
        for (Student student : students) {
            System.out.println("**************");
            System.out.println(student);
        }



    }

}