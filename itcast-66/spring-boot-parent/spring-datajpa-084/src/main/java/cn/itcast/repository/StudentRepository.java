package cn.itcast.repository;

import cn.itcast.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {


}