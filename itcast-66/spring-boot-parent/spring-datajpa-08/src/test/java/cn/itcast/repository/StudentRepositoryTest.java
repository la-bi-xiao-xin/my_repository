package cn.itcast.repository;

import cn.itcast.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

// springboot中单元测试固定代码
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {

    // 注入
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void save() {
        // 需求: 新增一条记录
        Student s = new Student();
        s.setName("刘禅");
        s.setAge(18);
        s.setSex("男");
        Student student = studentRepository.save(s);
        System.out.println("=======================" + student);
    }

    @Test
    public void findAll() {
        List<Student> studentList = studentRepository.findAll();
        for (Student student : studentList) {
            System.out.println("========================");
            System.out.println(student);
        }
    }

    @Test
    public void findByid() {
        Optional<Student> optional = studentRepository.findById(1);
        if(optional.isPresent()) {
            Student student = optional.get();
            System.out.println("查询结果: ======= " + student);
        }
    }
    @Test
    public void findByNameAndSex(){
        List<Student> student = studentRepository.findByNameAndSex("关羽", "男");
        for (Student student1 : student) {
            System.out.println("================");
            System.out.println(student1);
        }

    }
    @Test
    public void findByNameOrSex(){
        List<Student> student = studentRepository.findByNameOrSex("关羽", "男");
        for (Student student1 : student) {
            System.out.println("================");
            System.out.println(student1);
        }

    }
    @Test
    public void findByNameLike(){
        List<Student> student = studentRepository.findByNameLike("%禅");
        for (Student student1 : student) {
            System.out.println("================");
            System.out.println(student1);
        }

    }
    @Test
    public void findByIdIn(){
        ArrayList<Integer> idList = new ArrayList<>();
        idList.add(1);
        idList.add(2);
        idList.add(3);
        List<Student> student = studentRepository.findByIdIn(idList);
        for (Student student1 : student) {
            System.out.println("================");
            System.out.println(student1);
        }

    }

}