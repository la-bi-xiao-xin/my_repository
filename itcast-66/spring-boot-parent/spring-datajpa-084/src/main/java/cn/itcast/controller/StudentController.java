package cn.itcast.controller;

import cn.itcast.pojo.Student;
import cn.itcast.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController  //注解  标记为mvc 类
@RequestMapping("student")  //注解  类名与url 类名映射
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    @GetMapping("findAll")
    public List<Student> findAll(){
        Student student1 = new Student();
        student1.setName("张飞");
        student1.setAge(23);
        student1.setSex("男");
        Student student = studentRepository.save(student1);
        Student student2 = new Student();
        student1.setName("张包");
        student1.setAge(3);
        student1.setSex("男");
        Student student3 = studentRepository.save(student2);

        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }
    @GetMapping("findById/{id}")
     public Student findById(@PathVariable("id") Integer id){
         Optional<Student> byId = studentRepository.findById(id);
         Student student = byId.get();
         return student;
     }
}
