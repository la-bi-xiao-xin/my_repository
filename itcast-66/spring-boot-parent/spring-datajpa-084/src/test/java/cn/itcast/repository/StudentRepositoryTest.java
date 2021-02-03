package cn.itcast.repository;
import cn.itcast.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

   @Test
    public void demo01() {
        // 根据id查询
        Optional<Student> optional = studentRepository.findById(2);
        if(optional.isPresent()) {
            Student student = optional.get();
            System.out.println(student);
        }
    }

    /*

    @Test
    public void demo02() {
        // 查询所有
        List<Student> studentList = studentRepository.findAll();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Test
    public void demo03() {
        // 添加用户
        Student student = new Student();
        student.setName("王五");
        student.setAge(15);
        student.setSex("女");

        Student s = studentRepository.save(student);
        System.out.println(s);
    }*/
}
